package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create employee")
    public Employee create(@RequestBody Employee e) {
        return service.createEmployee(e);
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee")
    public Employee get(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete employee")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
