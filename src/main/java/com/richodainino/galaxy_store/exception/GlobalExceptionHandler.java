package com.richodainino.galaxy_store.exception;

import com.richodainino.galaxy_store.handler.ResponseHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle not found exception with response
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    // Handle entity model validation
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errorMessages.add(violation.getMessage());
        }
        // Change list into string and remove the square bracket
        String message = errorMessages.toString().replace("[", "").replace("]", "");
        return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, message, null);
    }

}
