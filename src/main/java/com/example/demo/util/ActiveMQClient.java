package com.example.demo.util;

import com.example.demo.entity.Film;
import com.example.demo.entity.FilmOrder;
import com.example.demo.service.IFilmOrderService;
import com.example.demo.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQClient {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    static int index = 0;

    @Autowired
    IFilmService filmService;

    @Autowired
    IFilmOrderService filmOrderService;

    @JmsListener(destination = "order.topic")
    public void receiveQueue(String text) {
        if(null != text){
            System.out.println("---receiveQueue---ActiveMQClient收到的报文为:"+text);
        }
    }

    @JmsListener(destination = "order.topic")
    public void receiveQueue2(String text) {
        if(null != text){
            System.out.println("---receiveQueue2---ActiveMQClient收到的报文为:"+text);
        }
    }

    @JmsListener(destination = "order.queue")
    public void receiveQueue1(String text) {
        if(index < 100){
            if(null != text){
                System.out.println("--receiveQueue1---ActiveMQClient收到的报文为:"+text);
            }
            index++;
            Film film = new Film();
            film.setId(1);
            film.setNum(100-index);
            filmService.updateById(film);

            FilmOrder filmOrder = new FilmOrder();
            filmOrder.setFilmId(film.getId());
            filmOrder.setUserId(1);
            filmOrder.setNum(index);
            filmOrderService.insert(filmOrder);
        }
    }
}
