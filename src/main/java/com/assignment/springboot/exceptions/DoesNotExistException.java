package com.assignment.springboot.exceptions;

public class DoesNotExistException extends RuntimeException{

    public DoesNotExistException(String message){
super(message);
    }
}
