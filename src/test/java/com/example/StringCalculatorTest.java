package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void emptyStringShouldReturnZero() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void addShouldReturnOneNumber() {
        assertThat(StringCalculator.add("3")).isEqualTo(3);
    }

    @Test
    void addShouldReturnSumOfTwoNumbers() {
        assertThat(StringCalculator.add("3,6")).isEqualTo(9);
    }

    @Test
    void addShouldReturnSumOfUnknownAmountOfNumbers() {
        assertThat(StringCalculator.add("3,6,9")).isEqualTo(18);
    }

    @Test
    void addShouldHandleNewLineBetweenNumbers() {
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void addSupportDifferentDelimiters() {
        assertThat(StringCalculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void addShouldThrowExceptionForNegativeNumber() {
        assertThatThrownBy(() -> StringCalculator.add("2,-1,6,-3"))
                .hasMessageContaining("negatives not allowed ")
                .hasMessageContaining("-1 -3");
    }

    @Test
    void shouldNotAllowNumbersBiggerThanThousand() {
        assertThat(StringCalculator.add("2,1001")).isEqualTo(2);
    }
}
