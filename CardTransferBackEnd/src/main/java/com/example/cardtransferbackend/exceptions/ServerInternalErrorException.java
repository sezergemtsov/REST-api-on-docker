package com.example.cardtransferbackend.exceptions;

public class ServerInternalErrorException extends RuntimeException {
    public ServerInternalErrorException(String message) {
        super(message);
    }
}
