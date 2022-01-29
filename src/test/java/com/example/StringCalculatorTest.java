package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void emptyStringShouldReturnZero(){
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void addShouldReturnOneNumber(){
        assertThat(StringCalculator.add("3")).isEqualTo(3);
    }

    @Test
    void addShouldReturnSumOfTwoNumbers(){
        assertThat(StringCalculator.add("3,6")).isEqualTo(9);
    }


}
