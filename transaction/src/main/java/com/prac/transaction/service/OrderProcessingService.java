package com.prac.transaction.service;

import com.prac.transaction.repository.AuditLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prac.transaction.entity.Order;
import com.prac.transaction.entity.Product;
import com.prac.transaction.handler.InventoryHandler;
import com.prac.transaction.handler.OrderHandler;
import com.prac.transaction.handler.PaymentValidatorHandler;
import com.prac.transaction.handler.AuditLogHandler;

@Service
public class OrderProcessingService {

    private final OrderHandler orderHandler;
    private final InventoryHandler inventoryHandler;
    private final AuditLogHandler auditLogHandler;
    private final PaymentValidatorHandler paymentValidatorHandler;

    public OrderProcessingService(OrderHandler orderHandler, InventoryHandler inventoryHandler,
            AuditLogHandler auditLogHandler, PaymentValidatorHandler paymentValidatorHandler) {
        this.orderHandler = orderHandler;
        this.inventoryHandler = inventoryHandler;
        this.auditLogHandler = auditLogHandler;
        this.paymentValidatorHandler = paymentValidatorHandler;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Order placeOrder(Order order) {
        Product product = inventoryHandler.getProduct(order.getProductId());
        validateStock(order, product);
        order.setTotalPrice(order.getQuantity() * product.getPrice());

        Order saveOrders = null;
        try {
            saveOrders = orderHandler.saveOrder(order);
            updateInventoryStock(order, product);
            auditLogHandler.logAuditDetails(order, "Order placement success!");

        } catch (Exception e) {
            auditLogHandler.logAuditDetails(order, "Order placement failed");

        }

        return saveOrders;

    }

    private void validateStock(Order order, Product product) {
        if (product.getStockQuantity() < order.getQuantity()) {
            throw new RuntimeException("Stock not availble");

        }
    }

    private void updateInventoryStock(Order order, Product product) {
        int netQuantity = product.getStockQuantity() - order.getQuantity();
        product.setStockQuantity(netQuantity);
        inventoryHandler.updateProductDetails(product);
    }

}
