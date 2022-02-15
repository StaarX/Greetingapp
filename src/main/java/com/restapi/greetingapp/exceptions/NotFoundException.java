package com.restapi.greetingapp.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }
    public NotFoundException(String message) {
        super(message);
    }
}
