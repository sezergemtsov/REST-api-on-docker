package com.example.cardtransferbackend.models;

public record TransInfo(String cardFromNumber,
                        String cardFromValidTill,
                        String cardFromCVV,
                        String cardToNumber,
                        TransferAmount amount) {
}
