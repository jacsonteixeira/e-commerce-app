package com.jteixeira.ecommerce.handler;

import com.jteixeira.ecommerce.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handle(BusinessException exception) {
        return status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException exception) {
        return status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                            var fieldName = ((FieldError) error).getField();
                            var errorMessage = error.getDefaultMessage();
                            errors.put(fieldName, errorMessage);
                        }
                );

        return status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }
}
