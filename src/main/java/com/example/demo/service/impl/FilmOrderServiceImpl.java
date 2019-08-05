package com.example.demo.service.impl;

import com.example.demo.dao.IFilmDao;
import com.example.demo.dao.IFilmOrderDao;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmOrder;
import com.example.demo.service.IFilmOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.util.activeMqServer;
import com.example.demo.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fenglang
 * @since 2019-07-25
 */
@Service
public class FilmOrderServiceImpl extends ServiceImpl<IFilmOrderDao, FilmOrder> implements IFilmOrderService {

    @Autowired
    IFilmOrderDao filmOrderDao;

    @Autowired
    IFilmDao filmDao;

    @Autowired
    activeMqServer activeMqServer;

    @Override
    public ResponseMessage orderByQueue(Film film){
        if(film == null || film.getId() == null){
            film = new Film();
            // 默认买id=1的电影
            film.setId(1);
        }
        String str = String.valueOf(new Random().nextInt(100000));
        System.out.println("随机产生的用户id为：" + str);
        activeMqServer.sendMessage(str);
        return new ResponseMessage(0,"已经将用户" + str +  "加入到队列");
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResponseMessage order(Film film, HttpServletRequest request){
        if(film == null || film.getId() == null){
            film = new Film();
            // 默认买id=1的电影
            film.setId(1);
        }
        String userId = request.getParameter("userId");
        if(userId == null){
            userId = "1";
        }
        synchronized (this){
            Film film1 = filmDao.selectById(film);
            System.out.println(film1);
            //判断数量
            if(film1.getNum() > 0){
                FilmOrder filmOrder = new FilmOrder();
                filmOrder.setFilmId(film1.getId());
                filmOrder.setUserId(Integer.valueOf(userId));
                // 每次买一张票
                filmOrder.setNum(1);
                filmOrder.setId(null);
                filmOrderDao.insert(filmOrder);
                // 更新余票
                film1.setNum(film1.getNum()-1);
                filmDao.updateById(film1);
                return new ResponseMessage(0,"购票成功,还剩余票数为：" + film1.getNum());
            }else{
                return new ResponseMessage(1,"无余票");
            }
        }
    }
}
