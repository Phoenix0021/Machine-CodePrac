package com.vendingmachine.service;

import java.util.List;

import com.vendingmachine.model.Product;

public interface InventoryService {
    void addProduct(Product product);
    boolean isProductAvailable(String productId);
    void reduceQuantity(String productId);
    int getQuantity(String productId);
    Product getProduct(String productId);
    List<Product> getAllProducts();




    

}
