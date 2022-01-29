package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void emptyStringShouldReturnZero(){
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }


}
