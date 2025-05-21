package com.vendingmachine.model;

public class Payment {

    // amount & method
    private final int amount ;
    private final PaymentMethod method;


    public Payment(int amount, PaymentMethod method){
        this.amount = amount ;
        this.method = method ;
    }

    public int getAmount(){
        return amount;
    }

    public PaymentMethod getMethod(){
        return method;
    }

}
