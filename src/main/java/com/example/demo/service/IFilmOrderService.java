package com.example.demo.service;

import com.example.demo.entity.Film;
import com.example.demo.entity.FilmOrder;
import com.baomidou.mybatisplus.service.IService;
import com.example.demo.util.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fenglang
 * @since 2019-07-25
 */
public interface IFilmOrderService extends IService<FilmOrder> {\

    /**
     * 订票
     * @param film
     * @param request
     * @return
     */
    public ResponseMessage order(Film film, HttpServletRequest request);

    /**
     * 订票 使用队列
     * @param film
     * @return
     */
    public ResponseMessage orderByQueue(Film film);
}
