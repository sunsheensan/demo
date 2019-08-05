package com.example.demo;

public class TestM {
    public static void main(String[] args) {
        for(EnumTest e:EnumTest.values()){
            System.out.println(e.toString() + e.ordinal());
        }
        EHan eHan = EHan.getLanHanInstance();
        EHan eHan1 = EHan.getLanHanInstance();
        System.out.println(eHan == eHan1);
        LanHan lanHan = LanHan.getLanHanInstance();
        LanHan lanHan1 = LanHan.getLanHanInstance();
        System.out.println(lanHan == lanHan1);
    }
}
