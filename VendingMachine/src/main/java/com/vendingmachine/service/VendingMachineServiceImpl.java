package com.vendingmachine.service;

import com.vendingmachine.model.PaymentMethod;
import com.vendingmachine.model.Product;
import com.vendingmachine.model.Transaction;

public class VendingMachineServiceImpl implements VendingMachineService {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final TransactionService transactionService;

    public VendingMachineServiceImpl(InventoryService inventoryService, PaymentService paymentService,
            TransactionService transactionService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.transactionService = transactionService;
    }

    @Override
    public void displayProducts() {
        System.out.println("Available Products");
        for (Product product : inventoryService.getAllProducts()) {
            System.out.println("ID: " + product.getProductId() +
                    ", Name: " + product.getProductName() +
                    ", Price: " + product.getPrice() +
                    ", Quantity: " + product.getQuantity());
        }

    }

    @Override
    public boolean selectProduct(String productId) {
        return inventoryService.isProductAvailable(productId);
    }

    @Override
    public boolean makePaymentAndDispense(String productId, int amount, PaymentMethod method) {
        // Check if product is available
        if (!inventoryService.isProductAvailable(productId)) {
            System.out.println("Product is not available.");
            return false;
        }

        Product product = inventoryService.getProduct(productId);

        // Check if payment amount matches product price
        if (amount < product.getPrice()) {
            System.out.println("Insufficient amount provided.");
            return false;
        }

        // Make payment
        boolean paymentSuccess = paymentService.makePayment(amount, method);
        if (!paymentSuccess) {
            System.out.println("Payment failed.");
            return false;
        }

        // Reduce inventory quantity
        inventoryService.reduceQuantity(productId);

        // Record transaction
        String transactionId = java.util.UUID.randomUUID().toString();
        java.time.LocalDateTime timeStamp = java.time.LocalDateTime.now();
        Transaction transaction = new Transaction(transactionId, productId, amount, timeStamp);
        transactionService.recordTransaction(transaction);

        System.out.println("Product dispensed successfully.");
        return true;
    }

}
