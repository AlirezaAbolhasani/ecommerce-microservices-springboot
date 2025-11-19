📐 Architecture Diagram

<img width="441" height="559" alt="image" src="https://github.com/user-attachments/assets/253bb9d1-7430-42a9-af17-f526593df24d" />

🛒 Ecommerce Microservices with Spring Boot
A modular, production-ready e-commerce backend built with Spring Boot, showcasing microservice architecture,clean code practices, and modern Java tooling.
This project is part of my freelance portfolio to demonstrate backend capabilities for international clients.

<img width="519" height="197" alt="image" src="https://github.com/user-attachments/assets/a73513b9-9911-495c-afbd-44ed5b6afff9" />

Each service is fully isolated, follows Database per Service pattern, and communicates via REST APIs. Swagger UI is enabled for each service using Springdoc OpenAPI.
----------------------------------------------------------------------------------------------------
🧰 Tech Stack

Java 17, Spring Boot 3

Spring Web, Spring Data JPA, Spring cloud

Design and think depend on container and Microservice Based

PostgreSQL (per service)

ModelMapper & MapStruct (DTO mapping)

Springdoc OpenAPI (springdoc-openapi-starter-webmvc-ui)

Global Exception Handling with @RestControllerAdvice

Swagger annotations: @Operation, @ApiResponses, @Schema
----------------------------------------------------------------------------------------------------

<img width="198" height="272" alt="image" src="https://github.com/user-attachments/assets/412588a5-c44e-4c0a-9ee5-f4e3e3a5a3b2" />


controller: REST endpoints with Swagger annotations

dto: Data Transfer Objects with MapStruct/ModelMapper

entity: JPA entities

repository: Spring Data interfaces

service: Business logic

exception: Custom exceptions + @RestControllerAdvice

config: Swagger, database, and other configurations

----------------------------------------------------------------------------------------------------
🔐 API Documentation

Each service exposes its own Swagger UI via Springdoc:

http://localhost:8081/swagger-ui.html → User Service

http://localhost:8082/swagger-ui.html → Product Service

http://localhost:8084/swagger-ui.html → Payment Service

http://localhost:8083/swagger-ui.html → Order Service

All endpoints are documented using @Operation, @ApiResponses, and @Schema.
----------------------------------------------------------------------------------------------------
🧪 How to Run Locally

1- Make sure you have Java 17, PostgreSQL, and optionally Docker installed.

2- Clone the repo:

   git clone https://github.com/AlirezaAbolhasani/ecommerce-microservices-springboot.git

3- Configure each service's application.yml with its own DB credentials.

4- Run each service:

   cd ecommerce-user-service
   ./mvnw spring-boot:run
   
5- Access Swagger UI for each service to test endpoints.

----------------------------------------------------------------------------------------------------
📈 Why This Project Matters

This project demonstrates:

✅ Real-world microservice separation

✅ Clean code and layered architecture

✅ Swagger-powered API documentation

✅ Exception handling with @RestControllerAdvice

✅ DTO mapping with ModelMapper & MapStruct

✅ PostgreSQL integration with JPA
----------------------------------------------------------------------------------------------------
💼 About Me

I’m a backend developer specializing in SpringBoot, microservices, and clean architecture. This project is part of my freelance portfile to showcase my ability to build scalable, maintainable systems for international clients.

📧 Contact me: [+989193714871] 🌐 [https://www.linkedin.com/in/alirezaabolhasani] / [https://github.com/AlirezaAbolhasani] / GitLab: [none]

----------------------------------------------------------------------------------------------------
📜 License

This project is open for review and demonstration purposes. For commercial use or collaboration, feel free to reach out.
Let me know if you'd like this README formatted for GitLab with badges, CI status, or even a Docker Compose setup to make it runnable with one command.
