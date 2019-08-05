package com.example.demo.util;

import org.apache.velocity.exception.MathException;
import org.springframework.stereotype.Component;

//@Component
public class ToBeTest implements IToBeTest{
    @Override
    public int add(int a,int b){
        int c = a+ b;
        System.out.println(c);
        return c;
    }
    @Override
    public void sub(){
        int index = 10;
        do{
            index--;
            System.out.println(index);
        }while(index > 0);
    }
    @Override
    public ResponseMessage rm(){
//        return new ResponseMessage(0,"成功");
        return null;
    }

    @Override
    public int mod(int a, int b) {
        if(b == 0){
            throw new MathException("除数不能为0");
        }else if(a == 0){
            return 0;
        }else{
            return a/b;
        }
    }
}
