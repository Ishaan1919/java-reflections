package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student{
    public Student(String message){
        System.out.println(message);
    }
    public void display(){
        System.out.println("olleh this is the display method");
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        try{
            dynamicallyCreateObject();
        }
        catch (NoSuchMethodException  | InvocationTargetException  | InstantiationException  | IllegalAccessException e){
            e.getStackTrace();
        }

    }

    public static void dynamicallyCreateObject() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class obj = Student.class;
        Constructor c = obj.getConstructor(String.class);
        Student newObj = (Student) c.newInstance("Hello");
        newObj.display();
    }
}
