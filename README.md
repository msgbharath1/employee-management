# Employee Management API

A RESTful Employee Management API built with Spring Boot 3, Java 17, and Maven for managing employee information.
The project includes an OpenAPI YAML specification that documents the API endpoints, request/response payloads,
and service contracts for easy reference.

## Features

- Create Employee
- Retrieve Employee by ID
- Retrieve All Employees
- Delete Employee
- OpenAPI 3 Specification
- Swagger UI Integration
- Maven-based Build
- Validation and Exception Handling
- Layered Architecture (Controller, Service and Data Responsibilities)

## Technology Stack

- Java 17
- Spring Boot 3.3.5
- Maven
- Open API Spec For Documentation (OAS 3.0.0)
- Swagger UI
- Spring Validation
- Git & GitHub

## Project Structure

```text
employee-openapi-project
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.employee.management
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── model
│   │   │       ├── exception
│   │   │       └── EmployeeApiApplication.java
│   │   └── resources
│   │       ├── employee_management_api.yaml
│   └── test
|       └── com.employee.management
│            ├── controller
│            ├── service
└── pom.xml
```

Compile project:

```bash
mvn clean install
```

Run application:

```bash
mvn spring-boot:run
```

## API Endpoints

### Get All Employees

```http
GET /employees
```

### Get Employee By ID

```http
GET /employees/{id}
```

### Create Employee

```http
POST /employees
```

### Delete Employee

```http
DELETE /employees/{id}
```

## Example Employee Payload

```json
{
  "employeeId": 1001,
  "name": "Bharath Sundaresan",
  "email": "bharath_sundaresan@gmail.com"
}
```

## Swagger Documentation

After starting the application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui.html
```

or

```text
http://localhost:8080/swagger-ui/index.html
```

## Build

```bash
mvn clean package
```

Generated JAR:

```bash
target/employee-management-api.jar
```

Run JAR:

```bash
java -jar target/employee-management-api.jar
```

## Future Enhancements

- Database Integration (MySQL/PostgreSQL)
- Spring Data JPA
- Docker Support
- Open API Code Generation
- Kubernetes Deployment
- JWT Authentication
- CI/CD using GitHub Actions
- Unit and Integration Tests

## Author

**Bharath Sundaresan**

Senior Technical Program Manager | API & Integration | Healthcare Technology

GitHub: https://github.com/msgbharath1
