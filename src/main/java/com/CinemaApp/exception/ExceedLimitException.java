package com.CinemaApp.exception;

public class ExceedLimitException extends RuntimeException {
    private String message;
    public ExceedLimitException(String message){
        this.message=message;
    }
}
