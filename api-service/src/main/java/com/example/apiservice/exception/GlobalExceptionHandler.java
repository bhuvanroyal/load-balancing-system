package com.example.apiservice.exception;

import com.example.apiservice.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(
            NoResourceFoundException ex,
            HttpServletRequest request) {
        return new ErrorResponse(
                java.time.LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Invalid endpoint",
                ex.getMessage(),
                request.getRequestURI()
        );
    }
}

