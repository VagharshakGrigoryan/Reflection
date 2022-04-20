package com.example;

import java.lang.reflect.Modifier;

public class ReflectionModifiers {
    private static final class CatModifier {
    }

    public static void main(String[] args) {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";

        Class<CatModifier> cl = CatModifier.class;
        System.out.println(s + "Class name: "+s1 + cl.getName());
        System.out.print(s + "Modifier of class: "+s1);

        int mods = cl.getModifiers();
        if (Modifier.isPrivate(mods)){
            System.out.print("private ");
        }
        if (Modifier.isAbstract(mods)){
            System.out.print("abstract ");
        }
        if (Modifier.isStatic(mods)){
            System.out.print("static ");
        }
        if (Modifier.isFinal(mods)){
            System.out.print("final ");
        }
    }
}
