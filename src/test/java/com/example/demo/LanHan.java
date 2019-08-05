package com.example.demo;

public class LanHan {
    private LanHan() {
    }
    private static LanHan lanHan = null;

    public synchronized static LanHan getLanHanInstance(){
        if (lanHan == null){
            lanHan = new LanHan();
        }
        return lanHan;
    }
}
