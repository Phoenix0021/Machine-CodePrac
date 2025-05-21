package com.vendingmachine.service;

import com.vendingmachine.model.Payment;
import com.vendingmachine.model.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {

    @Override
	public boolean makePayment(int amount, PaymentMethod paymentMethod) {
        if(amount < 0) return false;
        Payment payment = new Payment(amount, paymentMethod);
        System.out.println("Payment successful: " + amount + " via " + paymentMethod);

        return true;
 	}
}
