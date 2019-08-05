package com.example.demo.util;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class ActiveMQServer {
    @Autowired
    private JmsTemplate jmsTemplate;

    static int index = 0;

    Destination destination = new ActiveMQQueue("order.topic");

    public void sendMessage(String text) {
        index++;
        System.out.println("第" + index + "次加入队列");
        this.jmsTemplate.convertAndSend(destination, text);
        System.out.println("已经将用户" + text +  "加入到队列");
    }

}
