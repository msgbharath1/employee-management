package com.employee.management.service;

import com.employee.management.exception.EmployeeNotFoundException;
import com.employee.management.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {

    EmployeeService employeeService;

    @BeforeEach
    void setup() {
        employeeService = new EmployeeService();
    }

    @Test
    void shouldGetEmployee() {
        employeeService.createEmployee(
                new Employee(1L, "Bharath Sundaresan", "bharath_sundaresan@gmail.com"));

        Employee employee = employeeService.getEmployee(1L);

        assertEquals("Bharath Sundaresan", employee.getName());
        assertEquals(1L, employee.getId());
        assertEquals("bharath_sundaresan@gmail.com", employee.getEmail());
    }

    @Test
    void shouldDeleteEmployee() {
        employeeService.createEmployee(
                new Employee(1L, "Bharath Sundaresan", "bharath_sundaresan@gmail.com"));

        employeeService.deleteEmployee(1L);

        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.getEmployee(1L));
    }

    @Test
    void shouldUpdateEmployee() {
        EmployeeService s = new EmployeeService();

        s.createEmployee(new Employee(1L, "Bharath Sundaresan", "bharath_sundaresan@gmail.com"));

        Employee updated =
                s.updateEmployee(
                        1L,
                        new Employee(
                                1L,
                                "Bharath updated",
                                "bsundaresan_updated@test.com"));

        assertEquals(1L, updated.getId());
        assertEquals("Bharath updated", updated.getName());
        assertEquals("bsundaresan_updated@test.com", updated.getEmail());

        Employee retrieved = s.getEmployee(1L);
        assertEquals("Bharath updated", retrieved.getName());
        assertEquals("bsundaresan_updated@test.com", retrieved.getEmail());
    }
}
