package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionMethods {
    public static final class CatMethods {

        public String name = "Poxos";
        private int age = 7;
        short ears = 5;
        protected long tail = 30;

        public CatMethods() {
        }

        public CatMethods(int age) {
            this.age = age;
        }

        public CatMethods(String name, int age, short ears, long tail) {
            this.name = name;
            this.age = age;
            this.ears = ears;
            this.tail = tail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public short getEars() {
            return ears;
        }

        public void setEars(short ears) {
            this.ears = ears;
        }

        public long getTail() {
            return tail;
        }

        public void setTail(long tail) {
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";

        Class<?> cl = CatMethods.class;
        System.out.println(s + "Constructors: " + s1);

        Constructor<?>[] constructor = cl.getConstructors();
        int i = 0;
        for (Constructor<?> ctr : constructor) {
            System.out.print(s + "\tConstructor " + (++i) + ": ");
            Class<?>[] paramTypes = ctr.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(s1 + paramType.getName() + " ");

            }
            System.out.println();
        }
        try {
            Class<?>[] paramTypes = new Class<?>[]{
                    int.class
            };
            Constructor<?> ctr = cl.getConstructor(paramTypes);

            CatMethods cm = (CatMethods) ctr.newInstance(1);
            System.out.println(s + "Fields: " + s1 + " Age -" + cm.getAge() + " ,Name - "
                    + cm.getName() + " ,Ears - " + cm.getEars() + " ,Tail - " + cm.getTail());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            System.out.println(s + "Name: " + s2 + method.getName());
            System.out.println(s + "\tReturn types: " + s1 + method.getReturnType().getName());

            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print(s + "\tParam types: " + s);
            for (Class<?> paramType : paramTypes) {
                System.out.println(" " + paramType.getName());
            }
            System.out.println();
        }
        try {
            CatMethods cm = new CatMethods();
            Class<?>[] paramTypes = new Class<?>[]{int.class};

            Method method = cl.getMethod("setAge", paramTypes);
            Object[] objectArguments = new  Object[]{8};

            method.invoke(cm, objectArguments);
            System.out.println(s+ "Age: " + s1 + cm.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            CatMethods obj = new CatMethods();
            Class<?>[] paramTypes = new Class<?>[]{String.class};

            Method method = cl.getMethod("justMethod", paramTypes);
            Object[] arguments = new  Object[]{"Hello"};

            method.invoke(obj, arguments);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

