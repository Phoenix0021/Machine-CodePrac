package com.vendingmachine.service;

import com.vendingmachine.model.PaymentMethod;

public interface PaymentService {

    boolean makePayment(int amount, PaymentMethod method);

}
