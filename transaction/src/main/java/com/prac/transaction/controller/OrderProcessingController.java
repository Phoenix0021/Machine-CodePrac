package com.prac.transaction.controller;

import java.lang.annotation.Repeatable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prac.transaction.entity.Order;

import com.prac.transaction.service.OrderProcessingService;
import com.prac.transaction.service.Isolation.ReadCommitted;
import com.prac.transaction.service.Isolation.ReadUncommitted;
import com.prac.transaction.service.Isolation.RepeatableRead;

@RestController
@RequestMapping("/api/orders")
public class OrderProcessingController {
    private final OrderProcessingService orderProcessingService;
    private final ReadUncommitted readUncommitted;
    private final ReadCommitted readCommitted;
    private final RepeatableRead repeatableRead;

    public OrderProcessingController(OrderProcessingService orderProcessingService, ReadUncommitted readUncommitted, ReadCommitted readCommitted,RepeatableRead repeatableRead){
        this.orderProcessingService = orderProcessingService ;
        this.readUncommitted = readUncommitted;
        this.readCommitted = readCommitted;
        this.repeatableRead = repeatableRead;
    }


    @PostMapping
    public ResponseEntity<?>  placeOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderProcessingService.placeOrder(order));
    }

    @GetMapping("/isolation")
    public void testIsolation() throws InterruptedException{
        // readUncommitted.testReadUncommited(1);
        // readCommitted.testReadCommitted(1);
        repeatableRead.testReadCommitted(1);
    }
     

     

}
