package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.MathException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(Parameterized.class)
@SpringBootTest
//@ContextConfiguration
@Slf4j
public class ToBeTestTest{


    @Autowired
    IToBeTest toBeTest;
    //参数化
    private int numberA;
    private int numberB;
    private int expected;

    public ToBeTestTest(){

    }

//    public ToBeTestTest(int numberA, int numberB, int expected) {
//        this.numberA = numberA;
//        this.numberB = numberB;
//        this.expected = expected;
//    }

    //公用方法构造
    @Parameterized.Parameters(name = "{index}; add {0}+{1}={2}")
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][] {{1, 1, 2},{2, 2, 5},{2, 2, 5}});
    }

    @Test
    public void add() {
        log.info("------------");
        Assert.assertEquals(18,toBeTest.add(8,9));
//        IToBeTest toBeTest = new ToBeTest();
//        Assert.assertEquals(this.expected,toBeTest.add(this.numberA,this.numberB));
    }

//    @Test
//    public void sub() {
//    }
//
//    @Test(expected = MathException.class)
//    public void mod() {
//        toBeTest.mod(1,0);
//    }
//
//    @Test
//    public void rm(){
////        Assert.assertEquals(new ResponseMessage(0,"成功"),toBeTest.rm());
//        Assert.assertNull("abc",toBeTest.rm());
//    }
}