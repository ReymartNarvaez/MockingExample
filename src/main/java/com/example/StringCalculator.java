package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    public static int add(String string) {
        if (!string.isEmpty()) {
            List<Integer> numbers = stringToIntList(string);
            negatives(numbers);
            return numbers.stream()
                    .filter(number -> number < 1000)
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }

    private static void negatives(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream()
                .filter(num -> num < 0)
                .forEach(num -> stringBuilder.append(num).append(" "));
        if (!stringBuilder.toString().isEmpty()) {
            throw new RuntimeException("negatives not allowed " + stringBuilder);
        }
    }

    private static List<Integer> stringToIntList(String string) {
        return Arrays.stream(getSplit(string))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] getSplit(String string) {
        String delimiter = ",|\n";
        if (string.startsWith("//")) {
            String[] parts = string.split("\n", 2);
            delimiter = getDelimiter(parts[0].substring(2));

            return parts[1].split(delimiter);
        }
        return string.split(delimiter);
    }

    private static String getDelimiter(String delimiter) {
        if (delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
        }
        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
