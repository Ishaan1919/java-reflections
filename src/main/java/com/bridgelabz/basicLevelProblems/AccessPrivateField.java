package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Person{
    private String name = "olleh";
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try{
            getAndSetPrivateFields("name");
        }
        catch (Exception e){
            System.out.println("Some Exception occurred");
        }
    }
    public static void getAndSetPrivateFields(String name) throws Exception{

        Person p = new Person();
        Class obj = p.getClass();
        Field field = obj.getDeclaredField(name);
        field.setAccessible(true);
        String preValue = (String) field.get(p);
        field.set(p,"hello");
        String ans = (String) field.get(p);
        System.out.println(preValue);
        System.out.println(ans);

        int mod = field.getModifiers();
        String modi = Modifier.toString(mod);
        System.out.println(modi);
    }
}
