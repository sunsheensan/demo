package com.example.demo.util;

import com.example.demo.dubbo.IHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public  static  void  main(String[]  args){
        ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        IHelloService helloService = (IHelloService)context.getBean("helloService");
       // get service invocation proxy
        String hello=helloService.sayHello("world");
        //do invoke!
        System.out.println(hello);
        //cool,howareyou~
    }
}
