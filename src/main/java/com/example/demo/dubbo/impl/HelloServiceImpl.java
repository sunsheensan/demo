package com.example.demo.dubbo.impl;

import com.example.demo.dubbo.IHelloService;

public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
