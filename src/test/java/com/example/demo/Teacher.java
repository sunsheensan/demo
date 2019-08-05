package com.example.demo;

import java.util.*;

public class Teacher extends Person{
    Teacher(){
        super();
        System.out.println("teacher");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        for (String item : list) {
            System.out.println(item);
        }
        HashMap map = new HashMap(10);
        map.put(null,null);
        map.put(null,null);
        Set set = new TreeSet();
        set.add("abc");
        set.add("abc");
        Iterator it = set.iterator();
//        new Teacher();
//        int a = 0;
//        do {
//            System.out.println(a);
//        }while (a > 0);
//        while (a > 0){
//            System.out.println(a);
//        }
    }
}
