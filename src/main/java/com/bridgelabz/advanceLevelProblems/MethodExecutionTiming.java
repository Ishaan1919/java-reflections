package com.bridgelabz.advanceLevelProblems;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Sports{
    void display(){
        System.out.println("Its game time 🔥🔥🔥");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Sports s = new Sports();
        Class obj = Sports.class;
        Method[] methods = obj.getDeclaredMethods();

        for(Method i:methods){
            long start = System.nanoTime();
            i.invoke(s);
            long end = System.nanoTime();
            System.out.println("Method Execution time: " + (end-start));
        }
    }
}
