package com.pranav.SpringDataJPA.HospitalManagement.error;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(UsernameNotFoundException ex){

        ApiError error = new ApiError("Username not found : "+ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(error , error.getStatusCode());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException ex){

        ApiError error = new ApiError("Authentication failed: "+ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(error , error.getStatusCode());
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException ex){

        ApiError error = new ApiError("Invalid JWT Token: "+ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(error , error.getStatusCode());
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException ex){

        ApiError error = new ApiError("Access denied: "+ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(error , error.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenricException(Exception ex){

        ApiError error = new ApiError("Unexcepted error occurred: "+ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(error , error.getStatusCode());
    }

}
