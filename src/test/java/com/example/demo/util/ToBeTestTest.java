package com.example.demo.util;

import com.example.demo.DemoApplication;
import org.apache.velocity.exception.MathException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@WebAppConfiguration
@ComponentScan(basePackages = "com.example.demo.util")
@ContextConfiguration({"classpath:application.properties"})
public class ToBeTestTest {

    @Autowired
    IToBeTest toBeTest2;

    @Test
    public void add() {
        IToBeTest toBeTest = new ToBeTest();
        Assert.assertEquals(18,toBeTest.add(8,9));
    }

    @Test
    public void sub() {
    }

    @Test(expected = MathException.class)
    public void mod() {
        IToBeTest toBeTest = new ToBeTest();
        toBeTest.mod(1,0);
    }

    @Test
    public void rm(){
        IToBeTest toBeTest = new ToBeTest();
//        Assert.assertEquals(new ResponseMessage(0,"成功"),toBeTest.rm());
        Assert.assertNull("abc",toBeTest.rm());
    }
}