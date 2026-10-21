# Campus Placement Management System

A role-based web application designed to simplify and digitize campus placement activities by connecting students, recruiters, and placement administrators through a centralized platform.

**Project Status:** Backend Development — Swagger UI Integration

## Overview

The Campus Placement Management System is a full-stack project currently under development, with the backend implemented using Java and Spring Boot. It aims to streamline the campus recruitment process, including student profile management, job postings, applications, interview scheduling, and placement administration.

The system uses JWT-based authentication and role-based authorization to protect resources and ensure that students, recruiters, and administrators can access only the functionality permitted for their roles.

## Objectives

- Centralize campus placement activities on a single platform.
- Provide secure authentication and role-based access control.
- Enable recruiters to publish jobs and manage candidates.
- Allow students to manage their profiles and track job applications.
- Support interview scheduling, notifications, and placement administration.
- Build a maintainable backend that can be extended with a React frontend and cloud deployment.

## Technology Stack

| Category             | Technologies                 |
| -------------------- | ---------------------------- |
| Programming Language | Java                         |
| Backend Framework    | Spring Boot                  |
| API Architecture     | RESTful APIs                 |
| Security             | Spring Security, JWT         |
| Database             | MySQL                        |
| ORM and Persistence  | Spring Data JPA, Hibernate   |
| Build Tool           | Maven                        |
| API Documentation    | Swagger UI, OpenAPI          |
| Testing Tools        | Postman, Swagger UI          |
| Version Control      | Git, GitHub                  |
| Planned Frontend     | React, HTML, CSS, JavaScript |
| Planned Deployment   | Docker, AWS                  |

*The planned technologies are not yet considered completed implementation components.*

## Implemented Features

### 1. Authentication and Authorization

- User registration and login.
- JWT-based authentication.
- Password hashing using BCrypt.
- Role-based access control for students, recruiters, and administrators.
- Protected REST API endpoints.
- Ownership checks to restrict access to user-specific resources.
- Protection against access by inactive users.
- Public registration of administrator accounts is restricted.

### 2. Student Management

- Student profile creation and management.
- Student information retrieval and update operations.
- Student-specific access restrictions.

### 3. Recruiter Management

- Recruiter registration and authentication.
- Recruiter profile management.
- Role-based access to recruiter operations.

### 4. Resume Management

- Resume-related backend functionality.
- Access control for resume operations.

### 5. Job Management

- Job creation and management.
- Job-related API operations.
- Authorization for recruiter-specific actions.

### 6. Application Management

- Job application-related backend operations.
- Application status management.
- Access restrictions for application-related resources.

### 7. Interview Management

- Interview scheduling-related functionality.
- Interview information management.
- Role-based access to interview operations.

### 8. Notification Management

- Notification-related backend functionality.
- Protected access to notification resources.

### 9. Administrator Module

- Administrative user management.
- Placement administration functionality.
- Admin dashboard-related backend operations.
- Restricted administrator privileges.

### 10. Exception Handling and API Security

- Centralized handling of application errors.
- Handling for HTTP 400, 401, 403, 404, 409, and 500 responses.
- Restrictions on unauthorized administrative registration.
- Resource ownership and authorization validation.

### 11. Swagger UI and OpenAPI Integration

- Swagger/OpenAPI dependency integration.
- API documentation interface setup.
- Preparation for interactive REST API testing.

**Current milestone:** The backend modules and core security implementation are in place, and Swagger UI integration has been started. JWT authorization through Swagger and comprehensive API validation remain part of the next phase.

## Development Progress

- [☑️] Spring Boot project setup and Maven configuration
- [☑️] MySQL database integration
- [☑️] User authentication and JWT implementation
- [☑️] Spring Security configuration
- [☑️] Role-based authorization
- [☑️] Student management module
- [☑️] Recruiter management module
- [☑️] Resume management module
- [☑️] Job management module
- [☑️] Application management module
- [☑️] Interview management module
- [☑️] Notification management module
- [☑️] Administrator management and dashboard functionality
- [☑️] Resource ownership authorization
- [☑️] Inactive-user access protection
- [☑️] Centralized exception handling
- [☑️] Swagger UI integration started
- [ ] Validate API responses, error cases, and authorization rules
- [ ] Complete comprehensive backend integration testing
- [ ] Develop the React frontend
- [ ] Integrate frontend with backend REST APIs
- [ ] Perform end-to-end testing
- [ ] Dockerize the application
- [ ] Deploy the application to AWS or another suitable hosting platform
- [ ] Finalize project documentation and screenshots

## Getting Started

### Prerequisites

Install the following tools before running the backend:

- Java Development Kit (JDK)
- Maven
- MySQL Server
- Git
- An IDE such as IntelliJ IDEA or Visual Studio Code

### 1. Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd <YOUR_PROJECT_DIRECTORY>
```

Replace the placeholders with your actual GitHub repository URL and project directory.

### 2. Configure the Database

Create a MySQL database for the application.

```sql
CREATE DATABASE campus_placement;
```

Configure your database connection in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_placement
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Use your local MySQL credentials. Configure any other required Spring Boot properties according to your existing project setup.

**Security note:** Do not commit database passwords, JWT signing secrets, or other credentials to GitHub. Use environment variables or a local configuration file excluded from version control.

### 3. Build the Project

On Windows:

```bash
mvnw.cmd clean install
```

Alternatively, if Maven is installed globally:

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvnw.cmd spring-boot:run
```

The backend is configured to run on port `8080` in the current development setup.

### 5. Access Swagger UI

Once the application starts, open:

`http://localhost:8080/swagger-ui/index.html`

Swagger UI provides an interactive interface for exploring the documented REST APIs. Protected endpoint testing requires a valid JWT token and the appropriate role.

*The exact Swagger URL may vary if the application's context path or documentation configuration changes.*

## Security Design

The application follows a layered backend architecture with authentication, authorization, and resource validation.

- **Authentication:** Verifies user identity through JWT.
- **Authorization:** Enforces role-based permissions.
- **Password security:** Uses BCrypt password hashing.
- **Resource protection:** Applies ownership checks to restricted resources.
- **Error handling:** Returns appropriate HTTP status codes for common application errors.
- **Credential protection:** Secrets and passwords should be maintained outside the public repository.

## Project Architecture

The backend follows a layered architecture:

```text
Client / API Consumer
        |
        v
REST Controllers
        |
        v
Service Layer
        |
        v
Repository Layer
        |
        v
MySQL Database

Security Layer:
Spring Security + JWT
        |
        v
Authentication and Authorization
```

- **Controller layer:** Handles HTTP requests and responses.
- **Service layer:** Implements application and business logic.
- **Repository layer:** Manages database operations using Spring Data JPA.
- **Entity layer:** Represents persistent application data.
- **Security layer:** Handles JWT authentication and access control.

## Future Enhancements

The following improvements are planned as development continues:

1. Complete Swagger-based authentication and protected API testing.
2. Improve automated testing and integration test coverage.
3. Build a responsive React frontend for students, recruiters, and administrators.
4. Connect frontend workflows to the existing backend APIs.
5. Add comprehensive input validation and refine API error responses where necessary.
6. Introduce Docker-based deployment.
7. Deploy the application to a cloud platform.
8. Add screenshots, setup documentation, and usage instructions.

Additional features may be introduced after the core application is fully tested.

## Learning Outcomes

This project provides practical experience with:

- Building REST APIs using Spring Boot.
- Implementing JWT authentication and Spring Security.
- Designing a relational database using MySQL.
- Developing layered applications with Spring Data JPA.
- Applying role-based access control and resource ownership checks.
- Documenting APIs with Swagger and OpenAPI.
- Managing source code and project progress with Git and GitHub.

## Contribution and Development

This project is being developed incrementally. New features, testing improvements, frontend integration, and deployment will be added as development progresses.

## License

No license has been specified yet. All rights are reserved by the author unless otherwise stated.

---

**Campus Placement Management System**
*Developed using Java, Spring Boot, MySQL, and Spring Security.*

## Author

Parameshwar Boddupally
B.Tech — Computer Science and Engineering
