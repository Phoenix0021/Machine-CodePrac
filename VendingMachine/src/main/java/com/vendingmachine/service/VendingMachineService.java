package com.vendingmachine.service;

import com.vendingmachine.model.PaymentMethod;

public interface VendingMachineService {

    void displayProducts();

    boolean selectProduct(String productId);

    boolean makePaymentAndDispense(String productId, int amount, PaymentMethod method);

}
