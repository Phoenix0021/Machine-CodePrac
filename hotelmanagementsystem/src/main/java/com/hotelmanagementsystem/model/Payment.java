package com.hotelmanagementsystem.model;

import java.util.Date;

import com.hotelmanagementsystem.enums.PaymentMode;

public class Payment {

    private String paymentId;
    private double amount;
     private PaymentMode paymentMode;
    private Date paymentDate;

    public Payment(String paymentId, double amount,PaymentMode paymentMode){
        this.paymentId = paymentId;
        this.paymentMode = paymentMode;
        this.amount = amount;
        
    }

    public String getPaymentId(){
        return paymentId;
    }
    public double getAmount(){
        return amount;

    }
    public PaymentMode getPaymentMode(){
        return paymentMode;
    }



}
