package com.example.demo.controller;


import com.example.demo.entity.Film;
import com.example.demo.service.IFilmOrderService;
import com.example.demo.service.IFilmService;
import com.example.demo.util.LogAnno;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.TopicProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lqh
 * @since 2019-07-25
 */
@RestController
@RequestMapping("/film")
@Api("电影票")
public class FilmController {

    @Autowired
    IFilmService filmService;

    @Autowired
    IFilmOrderService filmOrderService;

    @Autowired
    TopicProducer topicProducer;

    @RequestMapping(value = "/orderByTopic",method = RequestMethod.POST)
    @ApiOperation(value = "购票采用队列的模式")
    public int orderByTopic(){
        topicProducer.sendMessage("11");
        return 1;
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ApiOperation(value = "购票")
    @LogAnno(operateType = "购票操作")
    public ResponseMessage order(@RequestBody Film film) {
        // 判断是否登录
        ///
       /* User user = (User)session.getAttribute("userInfo");
        if(null == user || null == user.getUserName()){
            return new ResponseMessage(1,"未登录");
        }*/
        return filmOrderService.orderByQueue(film);
    }
}

