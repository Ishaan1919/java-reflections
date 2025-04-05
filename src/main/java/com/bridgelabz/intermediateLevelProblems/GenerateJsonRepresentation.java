package com.bridgelabz.intermediateLevelProblems;

import java.lang.reflect.Field;

class Json{
    private String extension = ".json";
    public String format = "CSV Format";
    private String valueStorage = "Key Value Pair";

    public Json(){
        System.out.println("Object of Json created");
    }

    public Json(String extension, String format, String valueStorage) {
        this.extension = extension;
        this.format = format;
        this.valueStorage = valueStorage;
    }
}

public class GenerateJsonRepresentation {
    public static void main(String[] args) throws IllegalAccessException {
        Json obj = new Json();
        String ans = convertToJsonFormat(obj);
        System.out.println(ans);
    }

    public static String convertToJsonFormat(Json j) throws IllegalAccessException {
        StringBuilder jsonFormat = new StringBuilder("{\n");

        // get class
        Class obj = j.getClass();

        // get fields
        Field[] field = obj.getDeclaredFields();

        for(Field i:field){
            // get name
            String name = i.getName();

            // get value
            i.setAccessible(true);
            String value = (String) i.get(j);

            jsonFormat.append("\t" + "\"" + name + "\"" + " : " + "\"" + value + "\"" + ",\n");

        }
        jsonFormat.deleteCharAt(jsonFormat.length()-1);
        jsonFormat.deleteCharAt(jsonFormat.length()-1);
        jsonFormat.append("\n}");
        return jsonFormat.toString();
    }
}
