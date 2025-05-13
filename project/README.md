# Book Management System

A Spring Boot web application for managing authors and their books.

## Overview

This project is a simple web application that allows users to manage authors and their books. It demonstrates the use of Spring Boot, Spring Data JDBC, and Thymeleaf for building a full-featured web application with CRUD operations.

## Features

- Create, read, update, and delete authors
- Create, read, update, and delete books
- View details of authors and their books
- Search functionality for finding books and authors
- Form validation
- Responsive design

## Technologies Used

- Java 17
- Spring Boot 3.2.0
- Spring Data JDBC
- Thymeleaf
- H2 Database
- HTML/CSS/JavaScript

## Project Structure

- `src/main/java/com/example/bookmanagement/`
  - `BookManagementApplication.java`: Main application class
  - `model/`: Entity classes
  - `repository/`: Repository interfaces for data access
  - `service/`: Business logic services
  - `controller/`: Web controllers

- `src/main/resources/`
  - `application.properties`: Application configuration
  - `schema.sql`: Database schema
  - `data.sql`: Sample data
  - `templates/`: Thymeleaf templates
  - `static/`: Static resources (CSS, JS)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run `mvn spring-boot:run`
4. Open your browser and go to `http://localhost:8080`

## Database

The application uses an in-memory H2 database, which is automatically configured by Spring Boot. The database is initialized with sample data from `data.sql`.

You can access the H2 console at `http://localhost:8080/h2-console` with the following credentials:
- JDBC URL: `jdbc:h2:mem:bookdb`
- Username: `sa`
- Password: (leave blank)

## Relationships

- An author can have many books
- A book belongs to exactly one author

## License

This project is licensed under the MIT License - see the LICENSE file for details.