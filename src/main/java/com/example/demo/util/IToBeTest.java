package com.example.demo.util;

import org.springframework.stereotype.Component;

public interface IToBeTest {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a,int b);

    /**
     *
     */
    public void sub();

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int mod(int a,int b);

    /**
     *
     * @return
     */
    public ResponseMessage rm();
}
