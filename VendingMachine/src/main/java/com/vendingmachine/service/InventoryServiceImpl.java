package com.vendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vendingmachine.model.Product;

public class InventoryServiceImpl implements InventoryService {

    private final Map<String, Product> inventory = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        String productId = product.getProductId();

        if (inventory.containsKey(productId)) {
            Product existingProduct = inventory.get(productId);
            int updateQuantity = existingProduct.getQuantity() + product.getQuantity();
            existingProduct.setQuantity(updateQuantity);
        } else {
            inventory.put(productId, product);
        }

    }

    @Override
    public boolean isProductAvailable(String productId) {
        Product product = inventory.get(productId);
        if (product != null && product.getQuantity() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void reduceQuantity(String productId) {
        Product product = inventory.get(productId);
        if (product != null && product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1);
        } else {
            throw new IllegalArgumentException("Product not available or out of stock");
        }
    }

    @Override
    public int getQuantity(String productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            return product.getQuantity();
        }
        return 0;
    }
    
    @Override
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    @Override
    public List<Product> getAllProducts(){
        return new ArrayList<Product>(inventory.values());
    }

}