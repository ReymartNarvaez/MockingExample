package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String string) {
        if (!string.isEmpty()){
            List<Integer> numbers = Arrays.stream(string.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }
}
