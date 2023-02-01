package com.example.cardtransferbackend.exceptions;

import com.example.cardtransferbackend.exceptions.responseEntities.Respond400;
import com.example.cardtransferbackend.exceptions.responseEntities.Respond500;
import com.example.cardtransferbackend.repository.TransferRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    TransferRepository repository;

    public ExceptionHandlerAdvice(TransferRepository repository) {
        this.repository = repository;
    }

    @ExceptionHandler(IncorrectInputDataException.class)
    public ResponseEntity<Respond400> invalidCredentials(IncorrectInputDataException e) {
        return new ResponseEntity<>(new Respond400(e.getMessage(), repository.getId()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerInternalErrorException.class)
    public ResponseEntity<Respond500> invalidCredentials(ServerInternalErrorException e) {
        return new ResponseEntity<>(new Respond500(e.getMessage(), repository.getId()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
