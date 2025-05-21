package com.vendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vendingmachine.model.Transaction;

public class TransactionServiceImpl implements TransactionService {

    private final Map<String, Transaction> transactionStore = new HashMap<>();

    @Override
    public void recordTransaction(Transaction transaction) {
        transactionStore.put(transaction.getTransactionId(), transaction);

    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        return transactionStore.get(transactionId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactionStore.values());
    }

}
