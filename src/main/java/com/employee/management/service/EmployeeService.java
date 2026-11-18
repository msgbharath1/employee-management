package com.employee.management.service;

import java.util.*;
import java.util.concurrent.*;

import com.employee.management.exception.DuplicateEmployeeException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.employee.management.model.Employee;
import com.employee.management.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
    private final Map<Long, Employee> employees = new ConcurrentHashMap<>();

    @PostConstruct
    void loadData() {
        employees.put(
                1L,
                new Employee(
                        1L,
                        "Bharath Sundaresan",
                        "bharath_sundaresan@gmail.com"));

        employees.put(
                2L,
                new Employee(
                        2L,
                        "Mark Adams",
                        "mark_adams@test.com"));
    }


    public Employee createEmployee(Employee employee) {
        if (employees.containsKey(employee.getId())) throw new DuplicateEmployeeException(employee.getId());
        employees.put(employee.getId(), employee);
        return employee;
    }

    public Employee getEmployee(Long id) {
        if (!employees.containsKey(id)) throw new EmployeeNotFoundException(id);
        return employees.get(id);
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public void deleteEmployee(Long id) {
        if (employees.remove(id) == null)
            throw new EmployeeNotFoundException(id);
    }
}
