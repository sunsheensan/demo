package com.example.demo.util;

import org.apache.velocity.exception.MathException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ToBeTestTest {

    @Autowired
    IToBeTest toBeTest;

    @Test
    public void add() {
        Assert.assertEquals(18,toBeTest.add(8,9));
    }

    @Test
    public void sub() {
    }

    @Test(expected = MathException.class)
    public void mod() {
        toBeTest.mod(1,0);
    }

    @Test
    public void rm(){
//        Assert.assertEquals(new ResponseMessage(0,"成功"),toBeTest.rm());
        Assert.assertNull("abc",toBeTest.rm());
    }
}