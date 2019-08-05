package com.example.demo.util;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author yz.shi
 * @date 2018/4/9
 */
@Component
public class ConsumerC {
    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text 接收到的消息
     */
    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
        System.out.println("Consumer-C : 从out.queue队列收到的回复报文为:" + text);
    }
}
