package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.Method;

class Calculator{
    private int multiply(int a, int b) {
        System.out.println(a*b);
        return a*b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try{
            invokePrivateMethod("multiply");
        }
        catch (Exception e){
            System.out.println("Some Exception occurred");
        }
    }

    public static void invokePrivateMethod(String name) throws Exception{
        Calculator c = new Calculator();
        Class obj = c.getClass();

        Method method = obj.getDeclaredMethod(name,int.class,int.class);
        method.setAccessible(true);

        Object o = method.invoke(c,5,6);
        System.out.println(o);
    }
}
