package com.hotelmanagementsystem.services;
 
 import com.hotelmanagementsystem.model.Payment;

import java.util.*;

public class PaymentService {

    // Simulated in-memory store
    private final Map<String, Payment> paymentMap = new HashMap<>();

    /**
     * Create and store a new payment
     */
    public void createPayment(Payment payment) {
        paymentMap.put(payment.getPaymentId(), payment);
    }

    /**
     * Retrieve a payment by ID
     */
    public Payment getPaymentById(String paymentId) {
        return paymentMap.get(paymentId);
    }

 
    /**
     * Update payment status
     */
 

    /**
     * Delete a payment by ID (optional feature)
     */
    public void deletePayment(String paymentId) {
        paymentMap.remove(paymentId);
    }
}
