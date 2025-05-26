package com.prac.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.prac.transaction.entity.Product;
import com.prac.transaction.repository.InventoryRepository;

import jakarta.persistence.EntityManager;

@Service
public class ProductService {

    private final InventoryRepository inventoryRepository;
    private final EntityManager entityManager;

    public ProductService(InventoryRepository inventoryRepository, EntityManager entityManager) {
        this.inventoryRepository = inventoryRepository;
        this.entityManager = entityManager;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateStock(int productId, int stock) throws InterruptedException {
        Product product = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStockQuantity(stock);

        inventoryRepository.save(product);
        entityManager.flush();
        System.out.println("Transaction A: Stock updated to " + stock);
        Thread.sleep(5000);
        // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
     }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int checkStock(int productId) {

        Product product = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println("Transaction B: Read stock as " + product.getStockQuantity());
        return product.getStockQuantity();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int fetchStock(int productId) {

        Product product1 = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        System.out.println("Transaction B: First read stock as " + product1.getStockQuantity());// 40

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Product product2 = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        System.out.println("Transaction B: Second read stock as " + product2.getStockQuantity());// 40
        return product2.getStockQuantity();
    }

}
