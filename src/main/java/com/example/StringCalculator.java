package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String string) {
        if (!string.isEmpty()){
            List<Integer> numbers = Arrays.stream(getSplit(string))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }

    private static String[] getSplit(String string) {
        String delimiter = ",|\n";
        if (string.startsWith("//")) {
            String[] parts = string.split("\n", 2);
            delimiter = parts[0].substring(2);
            string = parts[1];
            return string.split(delimiter);
        }
        return string.split(delimiter);
    }
}
