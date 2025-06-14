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
   │   │               ├───config
   │   │               ├───exception
   │   │               └───modules
   │   │                   ├───album
   │   │                   │   ├───controller
   │   │                   │   ├───dto
   │   │                   │   ├───entity
   │   │                   │   ├───mapper
   │   │                   │   ├───repository
   │   │                   │   └───service
   │   │                   │       └───impl
   │   │                   ├───artist
   │   │                   │   ├───controller
   │   │                   │   ├───dto
   │   │                   │   ├───entity
   │   │                   │   ├───mapper
   │   │                   │   ├───repository
   │   │                   │   └───service
   │   │                   │       └───impl
   │   │                   ├───genre
   │   │                   │   ├───controller
   │   │                   │   ├───dto
   │   │                   │   ├───entity
   │   │                   │   ├───mapper
   │   │                   │   ├───repository
   │   │                   │   └───service
   │   │                   │       └───impl
   │   │                   ├───playlist
   │   │                   │   ├───controller
   │   │                   │   ├───dto
   │   │                   │   ├───entity
   │   │                   │   ├───mapper
   │   │                   │   ├───repository
   │   │                   │   └───service
   │   │                   │       └───impl
   │   │                   └───song
   │   │                       ├───controller
   │   │                       ├───dto
   │   │                       ├───entity
   │   │                       ├───mapper
   │   │                       ├───repository
   │   │                       └───service
   │   │                           └───impl
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

## Entity-Relationship Diagram (ERD) ![Mermaid](https://img.shields.io/badge/Mermaid-white?logo=mermaid)

```mermaid
erDiagram
    GENRE ||--o{ ARTIST : "has"
    ARTIST ||--o{ ALBUM : "creates"
    ALBUM ||--o{ SONG : "contains"
    SONG }o--o{ PLAYLIST : "belongs to"
    
    GENRE {
        Long id PK
        String name
        String description
    }
    ARTIST {
        Long id PK
        String name
        Long genre_id FK
    }
    ALBUM {
        Long id PK
        String name
        LocalDate releaseDate
        Long artist_id FK
    }
    SONG {
        Long id PK
        String name
        Duration duration
        Long album_id FK
    }
    PLAYLIST {
        Long id PK
        String name
        String description
    }
```


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
9999
Once the application is running, you can access the Swagger UI at the following URL:
http://localhost:8090/swagger-ui/index.html


## Postman Collection ![Postman](https://img.shields.io/badge/Postman-white?logo=postman)

The project includes a Postman collection for testing the API endpoints. You can find the collection file at the following path:

`src/main/java/com/example/pablomesaspringbootfundamentals/Music Management API.postman_collection.json`

To import the collection into Postman:

1. Open Postman.
2. Click on the `Import` button.
3. Select the `File` tab.
4. Click on `Choose Files` and navigate to the path mentioned above.
5. Select the `Music Management API.postman_collection.json` file and click `Open`.

This will import all the API endpoints into Postman, allowing you to test the API easily.


## Acknowledgements

Special thanks to [sergio.fuentes@nter.es](mailto:) for his invaluable support and guidance during my training period.

## Contact
For any inquiries or feedback, please contact:

Pablo José Mesa Pérez

[pablomesa@outlook.es](mailto:)

## License

Custom Attribution License

Copyright (c) 2024 Pablo José Mesa Pérez

Permission is granted to use, copy, modify, and distribute this software and its documentation, provided that:

1. The above copyright notice and this permission notice shall be included in all copies or substantial portions of the software.

2. Any use, reproduction, or distribution of the software, in its original or modified form, must include clear and visible attribution to Pablo José Mesa Pérez as the original author and creator of this content.

3. The name of Pablo José Mesa Pérez may not be used to endorse or promote products derived from this software without specific prior written permission.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```