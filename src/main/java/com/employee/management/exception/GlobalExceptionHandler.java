package com.employee.management.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(EmployeeNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorResponse(404, "Not Found", ex.getMessage()));
    }

    @ExceptionHandler(DuplicateEmployeeException.class)
    public ResponseEntity<ErrorResponse> duplicate(DuplicateEmployeeException ex) {
        return ResponseEntity.status(409).body(new ErrorResponse(409, "Conflict", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validArgument(MethodArgumentNotValidException ex) {
        String m = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(new ErrorResponse(400, "Validation Error", m));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generalError(Exception ex) {
        return ResponseEntity.status(500).body(new ErrorResponse(500, "Internal Server Error", ex.getMessage()));
    }
}
