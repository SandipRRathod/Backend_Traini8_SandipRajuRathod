package com.trainingcenter.entity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Entity //database table named as class name 
@Data
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Center name is required")   // check if the field is blank then throws exception
    @Size(max = 40, message = "Center name must be less than 40 characters") //particular condition 
    @Column(unique = true)
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @Column(unique = true)  //field should be uniqe 
    private String centerCode;

    @Valid  //for Address class validation 
    @Embedded  //is used inside an entity class to include an @Embeddable object.
    private CenterAddress address;

    @Min(value = 1, message = "Student capacity must be at least 1")
    private long studentCapacity;

    @ElementCollection  //store collections of objects class or wrapper class
    @NotEmpty(message = "At least one course must be offered")
    private List<String> courses;

    private long createdOn = Instant.now().getEpochSecond(); // at time when new creation Epoch time

    //Internally uses regx=[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}
    @Email(message = "Invalid email format") //if in the email @ is missing then throws exception 
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits") //regx for input should be number and 10digit
    private String contactPhone;
}
