package com.example.demo.service.impl;

import com.example.demo.entity.Film;
import com.example.demo.dao.IFilmDao;
import com.example.demo.service.IFilmService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-07-25
 */
@Service
public class FilmServiceImpl extends ServiceImpl<IFilmDao, Film> implements IFilmService {

}
