package com.restapi.greetingapp.exceptions;

public class InternalException extends RuntimeException{

    public InternalException() {
        super();
    }
    public InternalException(String message) {
        super(message);
    }
}
