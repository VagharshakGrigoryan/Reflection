package com.example;

import java.util.Map;

public class SimpleReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleReflection simpleReflection = new SimpleReflection();
        Class<?> cl = simpleReflection.getClass();

        // 1.use .getClass

        int[] arr = new int[10];
        Class<?> cl1 = arr.getClass();
        Class<?> cl2 = "world".getClass();
        Class<?> cl3 = Integer.valueOf(5).getClass();
        System.out.println(cl);
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);

        // 2.use .class

        Class<?> cl4 = SimpleReflection.class;
        Class<?> cl5 = int[].class;

        // 3.use Class.forName

        Class<?> cl6 = Class.forName("java.lang.String");
        System.out.println(cl6);

        Class<?> cl7 = Class.forName("[D");
        System.out.println(cl7);

        //4
        Class<?> cl8 = Integer.class.getSuperclass();
        System.out.println(cl8);

        Class<?> cl9 = Integer.class.getEnclosingClass();
        System.out.println(cl9);

        Class<?> cls = Map.Entry.class.getEnclosingClass();
        System.out.println(cls);

    }
}
