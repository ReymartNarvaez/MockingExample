package com.example;

public class StringCalculator {
    public static int add(String string) {
        if (string.contains(",")){
        String[] numbers = string.split(",");
        return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        } else if (!string.isEmpty()){
            return Integer.parseInt(string);
        }
        return 0;
    }
}
