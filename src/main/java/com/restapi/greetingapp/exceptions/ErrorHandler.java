package com.restapi.greetingapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> generalExceptionHandler(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, "Something went wrong, app is still in development.",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Object> timedoutExceptionHandler(ResourceAccessException ex, WebRequest request){
        return handleExceptionInternal(ex, "Requested resource timed out.",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(RemoteResourceNotAvailableException.class)
    public ResponseEntity<Object> remoteResourceNotAvailableExceptionHandler(ResourceAccessException ex, WebRequest request){
        return handleExceptionInternal(ex, "Remote resource is not available at the time.",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> NoEmployeeFoundHandler(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(InternalException.class)
    public ResponseEntity<Object> InternalHandler(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<Object> InvalidFieldHandler(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
