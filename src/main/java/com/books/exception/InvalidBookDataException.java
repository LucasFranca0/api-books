package com.books.exception;

public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message){
        super(message);
    }
}
