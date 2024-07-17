# Employee Management System - Backend

## Description

This is the backend component of the Employee Management System, a full-stack application. It provides a RESTful API for managing employee data, built with Spring Boot and connected to a MySQL database.

## Features

- CRUD operations for employee records
- RESTful API endpoints
- Data persistence with MySQL

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok

## Project Structure

1. `Employee` entity: Represents an employee with JPA annotations and Lombok
2. `EmployeeRepository` interface: Extends JpaRepository for database operations
3. `IEmployeeService` interface: Declares methods for business logic
4. `EmployeeService` class: Implements `IEmployeeService`
5. `EmployeeController`: REST controller handling HTTP requests

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- Maven

## How to Run

1. Clone the repository
2. Configure the database connection in `application.properties`
3. Run the Spring Boot application.

## API Endpoints

- GET `/hr-app/employees`: Retrieve all employees
- GET `/hr-app/employees/{id}`: Retrieve a specific employee
- POST `/hr-app/employees`: Create a new employee
- PUT `/hr-app/employees/{id}`: Update an existing employee
- DELETE `/hr-app/employees/{id}`: Delete an employee

## Project Status

This backend component is complete and functional. It's designed to work in conjunction with the frontend component of the Employee Management System.

## Learning Objectives

- Building RESTful APIs with Spring Boot
- Data persistence with JPA and Hibernate
- Backend application architecture

## Implementation Details

- Uses Spring Boot to create a RESTful API
- JPA with Hibernate for ORM, simplifying database interactions
- Implements service layer pattern for business logic

---

This backend is part of a full-stack Employee Management System. For the complete application, please also refer to the frontend repository.