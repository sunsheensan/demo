package com.example.demo.util;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yz.shi on 2018/4/9.
 */
@Component
public class ConsumerB {
    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text 接收到的消息
     */
    @JmsListener(destination = "yzshi_queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("----------------Consumer-B : 收到的报文为:" + text);
        return text;
    }

    @JmsListener(destination = "yzshi_queue")
    public void printReceiveQueue(String text) {
        System.out.println("+++++++++++++++++Consumer-B : 收到的报文为:" + text);
    }

    @JmsListener(destination = "topic1",containerFactory = "jmsListenerContainerTopic")
    public void printReceiveQueue1(MapMessage text) {
        try {
            System.out.println("+++++++++++++++++Consumer-B : 收到的报文为:" + text.getString("reqDesc"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}