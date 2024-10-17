# Proyecto pablo-mesa-SpringBoot-fundamentals

![Java](https://img.shields.io/badge/Java-17-%23FFA500?labelColor=blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-6DB33F?logo=spring-boot)
![Maven](https://img.shields.io/badge/Maven-3.8.4-purple?logo=apache-maven&logoColor=orange)
![H2](https://img.shields.io/badge/H2-2.3.232-007396)
![Validation](https://img.shields.io/badge/Validation-2.0.1.Final-85EA2D)
![MapStruct](https://img.shields.io/badge/MapStruct-1.5.5.Final-orange)
![Lombok](https://img.shields.io/badge/Lombok-1.18.34-f80000)
![Swagger](https://img.shields.io/badge/Swagger-2.6.0-85EA2D?logo=swagger)

## Description

This project is a Spring Boot application that demonstrates the fundamentals of Spring Boot with a modular structure. It
includes the following modules:

## Project structure

```
────src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───example
    │   │           └───pablomesaspringbootfundamentals
    │   │               └───modules
    │   │                   ├───album
    │   │                   │   ├───controller
    │   │                   │   ├───dto
    │   │                   │   ├───entity
    │   │                   │   ├───mapper
    │   │                   │   ├───repository
    │   │                   │   └───service
    │   │                   ├───artist
    │   │                   │   ├───controller
    │   │                   │   ├───dto
    │   │                   │   ├───entity
    │   │                   │   ├───mapper
    │   │                   │   ├───repository
    │   │                   │   └───service
    │   │                   ├───genre
    │   │                   │   ├───controller
    │   │                   │   ├───dto
    │   │                   │   ├───entity
    │   │                   │   ├───mapper
    │   │                   │   ├───repository
    │   │                   │   └───service
    │   │                   ├───playlist
    │   │                   │   ├───controller
    │   │                   │   ├───dto
    │   │                   │   ├───entity
    │   │                   │   ├───mapper
    │   │                   │   ├───repository
    │   │                   │   └───service
    │   │                   └───song
    │   │                       ├───controller
    │   │                       ├───dto
    │   │                       ├───entity
    │   │                       ├───mapper
    │   │                       ├───repository
    │   │                       └───service
    │   └───resources
    └───test
        └───java
            └───com
                └───example
                    └───pablomesaspringbootfundamentals
```

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.4**
- **Maven 3.8.4**
- **H2 Database 2.3.232**
- **Spring Boot Starter Web**
- **Spring Boot Starter Validation**
- **Spring Boot Starter Data JPA**
- **Lombok 1.18.34**
- **MapStruct 1.5.5.Final**
- **Swagger 2.6.0**

## Getting Started

To run the application, use the following command:

```bash
mvn spring-boot:run
```

## Connecting to the H2 Database

To connect to the H2 database through the H2 console, follow these steps:

1. Start the application using the command mentioned above.
2. Open your web browser and navigate to http://localhost:8090/h2-console.
3. Use the following settings to connect:

- JDBC URL: jdbc:h2:file:./data/music_management
- Username: Nter
- Password: 1234

The database file is located at [./data/music_management](./data/music_management) relative to the project root
directory.


### Accessing Swagger UI

Once the application is running, you can access the Swagger UI at the following URL: 
http://localhost:8090/swagger-ui/index.html