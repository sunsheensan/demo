package com.example.demo;

public class EHan {
    private EHan() {
    }

    private static EHan eHan = new EHan();

    public static EHan getLanHanInstance(){
        return eHan;
    }
}
