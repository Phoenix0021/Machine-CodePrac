package com.prac.transaction.handler;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Service;

import com.prac.transaction.entity.Product;
import com.prac.transaction.repository.InventoryRepository;

@Service
public class InventoryHandler {
    private final  InventoryRepository inventoryRepository;
    public InventoryHandler(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public Product updateProductDetails(Product product){
        return inventoryRepository.save(product);
    }

    public Product getProduct(int id){
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with provided id not found"));
    }



}
