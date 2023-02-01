package com.example.cardtransferbackend.exceptions;

public class IncorrectInputDataException extends RuntimeException {
    public IncorrectInputDataException(String message) {
        super(message);
    }
}
