package com.vendingmachine.service;

import java.util.List;

import com.vendingmachine.model.Transaction;

public interface TransactionService {
    void recordTransaction(Transaction transaction);
    Transaction getTransactionById(String transactionId);
    List<Transaction> getAllTransactions();
}
