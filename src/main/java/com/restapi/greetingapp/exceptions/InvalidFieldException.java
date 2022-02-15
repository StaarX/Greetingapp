package com.restapi.greetingapp.exceptions;

public class InvalidFieldException extends RuntimeException{

    public InvalidFieldException() {
        super();
    }
    public InvalidFieldException(String message) {
        super(message);
    }
}
