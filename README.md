# API GARDEN

## Overview
API GARDEN is a Spring Boot-based RESTful API for managing a gardening system. It provides functionalities to manage users, products, orders, and gardeners.

## Features
- **User Management**
- **Product Management**
- **Order Handling**
- **Gardener Management**

## Project Structure
```
API GARDEN/demo
├── src/main/java/com/example/demo
│   ├── controller/        # Controllers for handling requests
│   ├── entity/            # Entity classes representing database models
│   ├── repository/        # Repositories for database interactions
│   ├── service/           # Business logic services
│   ├── DemoApplication.java  # Main application entry point
│
├── src/main/resources
│   ├── application.properties  # Configuration file
│
├── pom.xml                # Maven build file
```

## Installation
### Prerequisites
- **Java 17+**
- **Maven 3+**
- **Spring Boot**

### Setup
1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   ```
2. **Navigate into the project directory:**
   ```sh
   cd API\ GARDEN/demo
   ```
3. **Build the project using Maven:**
   ```sh
   mvn clean install
   ```
4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| Resource  | Endpoint       | Method | Description         |
|-----------|---------------|--------|---------------------|
| **User**  | `/users`      | GET    | Get all users      |
| **User**  | `/users/{id}` | GET    | Get user by ID     |
| **Product** | `/products`  | GET    | Get all products   |
| **Order**  | `/orders`    | GET    | Get all orders     |
| **Gardener** | `/gardeners` | GET    | Get all gardeners |

## Configuration
Modify `src/main/resources/application.properties` to set up database connections and other configurations.

## License
This project is licensed under the **MIT License**.
