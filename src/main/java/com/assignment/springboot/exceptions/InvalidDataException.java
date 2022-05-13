package com.assignment.springboot.exceptions;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException(String message){
    super(message);
    }
}
