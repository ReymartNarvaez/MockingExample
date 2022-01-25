package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee = new Employee("1", 300.0);

    @Test
    void shouldReturnIdOne() {
        var result = employee.getId();

        assertEquals("1", result);
    }

    @Test
    void changeIdFromOneToThree() {
        employee.setId("3");

        var result = employee.getId();

        assertEquals("3", result);
    }

    @Test
    void shouldReturnSalaryThreeHundred() {
        var result = employee.getSalary();

        assertEquals(300.0, result);
    }

    @Test
    void changeSalaryFromThreeHundredToSixHundred() {
        employee.setSalary(600.0);

        var result = employee.getSalary();

        assertEquals(600.0, result);
    }

    @Test
    void paidShouldReturnTrue() {
        employee.setPaid(true);

        var result = employee.isPaid();

        assertTrue(result);
    }

    @Test
    void toStringShouldReturnIdOneAndSalaryThreeHundred() {
        var result = employee.toString();

        assertEquals("Employee [id=1, salary=300.0]", result);
    }
}