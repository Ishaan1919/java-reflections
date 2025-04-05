package com.bridgelabz.intermediateLevelProblems;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MathOperations{
    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String methodCall = "multiply";
        dynamicMethodCall(methodCall);
    }

    public static void dynamicMethodCall(String methodCall) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MathOperations mo = new MathOperations();
        Class obj = MathOperations.class;
        Method method = obj.getMethod(methodCall, int.class, int.class);
        int ans = (int) method.invoke(mo,2,3);
        System.out.println(ans);
    }
}
