package com.restapi.greetingapp.exceptions;

public class RemoteResourceNotAvailableException extends RuntimeException{

    public RemoteResourceNotAvailableException(String message){
        super(message);
    }
}
