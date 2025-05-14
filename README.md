# 📚 Book Store CRUD Application

A Spring Boot application that manages books, authors, and publishers using REST APIs and MySQL. Built as a portfolio project to demonstrate Spring Boot fundamentals including JPA, RESTful endpoints, pagination, and database connectivity.

---

## 🚀 Features

- 📖 Create, Read, Update, Delete (CRUD) operations for Books
- 👤 Manage authors and publishers
- 🔄 Pagination and sorting for book listings
- 🔍 Search books by title or author
- 🧩 Layered architecture (Controller, Service, Repository)
- 🛠️ Integrated with MySQL database

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Postman (for API testing)

---

## 🛠️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/bookstore-crud.git
cd bookstore-crud
```

### 2. Update Database Config in application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```
### 3. Run the Application
``` bash
./mvnw spring-boot:run
```

## 🧪API ENDPOINTS

### Books
| Method   | Endpoint          | Description                                 |
| `GET`    | `/api/books`      | Get all books (supports pagination/sorting) |
| `GET`    | `/api/books/{id}` | Get a book by ID                            |
| `POST`   | `/api/books`      | Add a new book                              |
| `PUT`    | `/api/books/{id}` | Update book details                         |
| `DELETE` | `/api/books/{id}` | Delete a book                               |

### Authors
| Method   | Endpoint          | Description     |
| `GET`    | `/api/authors`    | Get all authors |

### Publishers
| Method   | Endpoint          | Description        |
| `GET`    | `/api/publishers` | Get all publishers |




