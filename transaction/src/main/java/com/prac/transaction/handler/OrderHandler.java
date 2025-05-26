package com.prac.transaction.handler;

 
import org.springframework.stereotype.Service;

import com.prac.transaction.entity.Order;
import com.prac.transaction.repository.OrderRepository;

@Service
public class OrderHandler {
    private final OrderRepository orderRepository;
    public OrderHandler(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order){
         return  orderRepository.save(order);
           
    }


    
}
