package com.example.cardtransferbackend.repository;

import com.example.cardtransferbackend.models.TransInfo;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class TransferRepository {

    private final Map<String, TransInfo> transactionsStorage = new HashMap<>();
    private Integer currentId;

    public void addTransaction(TransInfo info) {
        transactionsStorage.put(String.valueOf(currentId++), info);
    }

    public Integer getId() {
        return currentId;
    }

    public boolean inspectCode(int code) {
        return transactionsStorage.containsKey(String.valueOf(code));
    }

}
