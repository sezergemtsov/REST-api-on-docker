package com.example.cardtransferbackend.service;

import com.example.cardtransferbackend.exceptions.responseEntities.Respond200;
import com.example.cardtransferbackend.models.TransInfo;
import com.example.cardtransferbackend.models.TransactionValidation;
import com.example.cardtransferbackend.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    TransferRepository repository;

    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }

    Logger logger = LoggerFactory.getLogger(TransferService.class);
    public Respond200 transfer(TransInfo info) {
        repository.addTransaction(info);
        logger.warn(info.toString());
        return new Respond200(String.valueOf(repository.getId()));
    }

    public Respond200 confirm(TransactionValidation validation) {
        logger.warn(validation.toString());
        return new Respond200(validation.operationId());
    }

}
