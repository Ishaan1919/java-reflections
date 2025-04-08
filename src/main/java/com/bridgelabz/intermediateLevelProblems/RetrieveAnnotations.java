package com.bridgelabz.intermediateLevelProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Author{
    String name() default "Author Name";
}

@Author(name = "Ishaan")
class Book{
    int price;
    String name;
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        Class obj = Book.class;

        if(obj.isAnnotationPresent(Author.class)){
            Author author = (Author)obj.getAnnotation(Author.class);
            System.out.println("Author name: " + author.name());
        }
        else{
            System.out.println("Annotation not found");
        }

    }
}
