package com.example;

public class StringCalculator {
    public static int add(String string) {
        if (!string.isEmpty())
            return Integer.parseInt(string);
        return 0;
    }
}
