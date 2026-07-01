# 📚 OnlineBookShop

A RESTful Online Book Shop API built with **Spring Boot**.

This project demonstrates the implementation of a layered architecture using Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, Hibernate and MySQL.

---

## 🚀 Features

- User Registration
- User Login
- JWT Authentication
- Password Encryption using BCrypt
- CRUD Operations for Books
- Request Validation
- Global Exception Handling
- Swagger/OpenAPI Documentation
- Layered Architecture
- DTO Pattern
- Spring Data JPA
- MySQL Database

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger / OpenAPI

---

## 📂 Project Structure

```
src
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
└── util
```

---

## 🔐 Authentication

Authentication is implemented using **JWT (JSON Web Token).**

### Authentication Flow

1. Register a new user.
2. Login using username and password.
3. Receive a JWT Token.
4. Send the token in every protected request.

Example:

```http
Authorization: Bearer your_jwt_token
```

---

## 📖 API Endpoints

### Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login user |

### Books

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get book by id |
| POST | `/books` | Add new book |
| PUT | `/books/{id}` | Update book |
| DELETE | `/books/{id}` | Delete book |

---

## ✅ Validation

The project validates user input using Jakarta Bean Validation.

Examples include:

- Blank fields
- Invalid values
- Invalid IDs

All validation errors are returned with meaningful HTTP responses.

---

## ❗ Exception Handling

Global Exception Handling is implemented using `@ControllerAdvice`.

Handled exceptions include:

- Resource Not Found
- Validation Errors
- Authentication Errors
- Bad Requests

---

## 📑 API Documentation

Swagger UI:

```
http://localhost:8081/swagger-ui/index.html
```

---

## ⚙️ How to Run

### Clone Repository

```bash
git clone https://github.com/ArshiaMohi/OnlineBookShop.git
```

### Configure Database

Update the `application.properties` file with your own MySQL credentials.

### Run the Application

```bash
mvn spring-boot:run
```

Or simply run the project directly from your IDE.

---

## 📌 Future Improvements

- Refresh Token
- Docker Support
- Unit Testing
- Integration Testing
- Pagination
- Search & Filtering
- Email Verification
- Redis Caching
- CI/CD Pipeline

---

## 👨‍💻 Author

**Arshia**

Backend Developer (Java & Spring Boot)

GitHub:
https://github.com/ArshiaMohi
