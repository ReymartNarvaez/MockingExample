package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class EmployeeManagerTest {

    @Test
    void payEmployeesShouldReturnTwo() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
        BankService bankService = new BankServiceStub();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var result = employeeManager.payEmployees();

        assertEquals(2, result);
    }

    @Test
    void payEmployeesShouldThrowRuntimeException() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        when(employeeManager.payEmployees()).thenThrow(new RuntimeException());
        var result = employeeManager.payEmployees();


        assertEquals(1, result);
    }

}