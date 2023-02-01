package com.example.cardtransferbackend.controller;

import com.example.cardtransferbackend.exceptions.responseEntities.Respond200;
import com.example.cardtransferbackend.models.TransInfo;
import com.example.cardtransferbackend.models.TransactionValidation;
import com.example.cardtransferbackend.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TransferController {

    TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/transfer")
    public Respond200 transfer(@RequestBody TransInfo info) {
        return service.transfer(info);
    }

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public Respond200 confirmOperation(@RequestBody TransactionValidation validation) {
        return service.confirm(validation);
    }
}
