package com.example;

import java.lang.reflect.Member;

public class FeaturesOfClass {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            printMembers(c.getFields());
            printMembers(c.getConstructors());
            printMembers(c.getMethods());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printMembers(Member[] mems) {
        for (Member mem : mems) {
            if (mem.getDeclaringClass() == Object.class) {
                continue;
            }
            String decl = mem.toString();
            System.out.println("   ");
            System.out.println(decl);
        }
    }
}
