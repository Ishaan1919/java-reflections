package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.*;
import java.lang.Class;

class ReflectionExampleClass{
    private int field1;
    private int field2;
    public String field3;

    public ReflectionExampleClass(){
        System.out.println("Parameter Less Constructor");
    }

    private ReflectionExampleClass(int one, int two, String three){
        this.field1 = one;
        this.field2 = two;
        this.field3 = three;
        System.out.println("Parameterized constructor called");
    }

    public void method1(){
        System.out.println("Public method1");
    }

    private void method2(){
        System.out.println("Private method2");
    }

}

public class GetClassInfo {


    public static void main(String[] args) {
        getClassInformation("GetClassInfo");
    }

    public static void getClassInformation(String className){
        ReflectionExampleClass obj = new ReflectionExampleClass();
        Class reflection = obj.getClass();

        Method[] declaredMethods = reflection.getDeclaredMethods();
        Method[] methods = reflection.getMethods();
        for(Method i:declaredMethods){
            int modifier = i.getModifiers();
            String mod = Modifier.toString(modifier);
            System.out.println("Method Name: " + i.getName() + ", " + mod);
        }
        System.out.println();
        for(Method i:methods){
            int modifier = i.getModifiers();
            String mod = Modifier.toString(modifier);
            System.out.println("Method Name: " + i.getName() + ", " + mod);
        }

        Constructor[] declaredConstructors = reflection.getDeclaredConstructors();
        Constructor[] constructors = reflection.getConstructors();
        for(Constructor i:declaredConstructors){
            System.out.println("Constructor Name: " + i.getName());
        }
        System.out.println();
        for(Constructor i:constructors){
            System.out.println("Constructor Name: " + i.getName());
        }

        Field[] declaredFields = reflection.getDeclaredFields();
        Field[] fields = reflection.getFields();
        for(Field i:declaredFields){
            int modifier = i.getModifiers();
            String mod = Modifier.toString(modifier);
            System.out.println("Field Name: " + i.getName() + ", " + i.getType() + ", " + mod);
        }
        System.out.println();
        for(Field i:fields){
            int modifier = i.getModifiers();
            String mod = Modifier.toString(modifier);
            System.out.println("Field Name: " + i.getName() + ", " + i.getType() + ", " + mod);
        }

    }
}
