package com.bridgelabz.intermediateLevelProblems;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Configurations{
    private static String API_KEY = "Soccer";
}

public class AccessModifyStaticFields {
    public static void main(String[] args) throws IllegalAccessException {
        accessAndModifyPrivateStaticFields();
    }

    public static void accessAndModifyPrivateStaticFields() throws IllegalAccessException {
        Configurations c = new Configurations();
        Class obj = c.getClass();
        Field[] field = obj.getDeclaredFields();
        for(Field i:field){
            System.out.println("lleh");
            int mod = i.getModifiers();
            String modString = Modifier.toString(mod);
            System.out.println(modString);
            if(modString.equals("private static") && Modifier.isStatic(mod)){
                System.out.println("hell");
                i.setAccessible(true);
                i.set(c,"Football");
                String val = (String) i.get(c);
                System.out.println(val);
            }
        }
    }
}
