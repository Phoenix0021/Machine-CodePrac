package com.vendingmachine.model;

import java.time.LocalDateTime;

public class Transaction {

    private final String transactionId;
    private String productId;
    private final int amountPaid;
    private final LocalDateTime timeStamp;

    public Transaction(String transactionId, String productId, int amountPaid, LocalDateTime timeStamp) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.amountPaid = amountPaid;
        this.timeStamp = timeStamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

}
