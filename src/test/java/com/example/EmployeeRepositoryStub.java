package com.example;

import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return List.of(new Employee("1", 99.0),
                new Employee("2", 300.0));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
