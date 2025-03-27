# GovTrainingHub Backend Project

## Setup Instructions

### Prerequisites

- Java 17 or later
- Maven
- Lombook
- MySQL
- Postman (for API testing)
- IDE (STS (Recommended), IntelliJ IDEA, Eclipse, or VS Code)

### Dependencies Used

The project includes the following dependencies:

- **Spring Boot DevTools** - For fast application restart and development convenience.
- **Spring Boot Web** - To build REST APIs.
- **Spring Boot JPA (Hibernate)** - For database interaction using JPA.
- **MySQL Driver** - To connect with the MySQL database.
- **Lombok** - To reduce boilerplate code by generating getters, setters, constructors, and other methods automatically.

#### About Lombok

Lombok is a Java library that helps minimize boilerplate code. It provides annotations like `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, and `@Data` to automatically generate methods like `toString()`, `equals()`, and `hashCode()`.

To enable Lombok in your IDE, install the Lombok plugin and ensure annotation processing is enabled.

### Installation & Setup

1. **Clone the Repository**

   ```sh
   git clone https://github.com/SandipRRathod/Backend_Traini8_SandipRajuRathod.git
   cd Backend_Traini8_SandipRajuRathod/GovTrainingHub
   ```

2. **Configure Database**

   - Create a MySQL database with a name of your choice (e.g., `gov_train_hub`).
   - Update `src/main/resources/application.properties` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Build & Run the Project**

   ```sh
   mvn clean install
   mvn spring-boot:run
   or if you are inside the pom.xml project directory:
   ./mvnw spring-boot:run
   ```

### API Endpoints

#### 1. Create a Training Center

**POST** `/api/center`

- Request Body (JSON):
  ```json
  {
    "centerName": "Sandip Training Center",
    "centerCode": "STC1234567890",
    "address": {
      "detailedAddress": "At Post Pathrud",
      "city": "Jalna",
      "state": "Maharashtra",
      "pincode": "431314"
    },
    "studentCapacity": 100,
    "courses": ["Java", "Spring Boot", "Angular"],
    "contactEmail": "sandiprathod2667@gmail.com",
    "contactPhone": "9876543210"
  }
  ```
- Response: `201 Created`

#### 2. Get All Training Centers

**GET** `/api/center/list`

- Response (JSON):
  ```json
  [
    {
    "centerName": "Sandip Training Center",
    "centerCode": "STC1234567890",
    "address": {
      "detailedAddress": "At Post Pathrud",
      "city": "Jalna",
      "state": "Maharashtra",
      "pincode": "431314"
    },
    "studentCapacity": 100,
    "courses": ["Java", "Spring Boot", "Angular"],
    "contactEmail": "sandiprathod2667@gmail.com",
    "contactPhone": "9876543210"
  }
  ]
  ```

### Validation Used

The project uses **Jakarta Bean Validation** annotations for validating inputs:

- `@NotNull` - Ensures the field is not null.
- `@Size(min, max)` - Validates the length of strings.
- `@Email` - Ensures valid email format.
- `@Pattern(regex)` - Validates strings against a regex pattern.
- `@Min(value)` - Ensures numerical values are above a minimum threshold.

### Embedded and ElementCollection Annotations

- `@Embedded` and `@Embeddable` are used to embed reusable objects within an entity.
- `@ElementCollection` is used for storing a collection of simple values or embeddable types.

### Error Handling

- **400 Bad Request**: Validation failures (e.g., incorrect email, invalid phone number, missing required fields)
- **500 Internal Server Error**: Unexpected system errors

### Global Exception Handling

The project includes a **global exception handler** to manage errors gracefully:

- **Validation Exception Handling:**

  ```java
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
  ```

- **Generic Exception Handling:**

  ```java
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGlobalException(Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong Please Try Again Later");
  }
  ```

### Testing

- Use **Postman** or `curl` for testing API requests.

### Future Enhancements

- Add user authentication (JWT-based security)
- Implement pagination for fetching training centers
- Deploy on AWS/GCP

---

This completes the setup for the **GovTrainingHub** backend. 🚀

