package com.employee.management.exception;

public class DuplicateEmployeeException extends RuntimeException {
    public DuplicateEmployeeException(Long id) {
        super("Employee already exists with id: " + id);
    }
}
