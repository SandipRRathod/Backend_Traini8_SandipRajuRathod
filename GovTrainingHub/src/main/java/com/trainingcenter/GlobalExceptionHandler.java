package com.trainingcenter;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  //enables a global exception handler class  or @controller advice for controller
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) //a validation class exception for validation
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {  //sending all validation massage if got exception or error
            String fieldName = ((FieldError) error).getField();  //on particular field 
            String errorMessage = error.getDefaultMessage();     //with massage 
            errors.put(fieldName, errorMessage);                 //sending a json fromat using Hashmap 
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); //fannaly return the json
    }
    
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    
    @ExceptionHandler(Exception.class) // exception handler method
    public ResponseEntity<?> exception() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong Please Try Again Later"); //finally return all Runtime exception as json
    }
}
