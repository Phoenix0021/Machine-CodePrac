package com.prac.transaction.service.Isolation;

import org.springframework.stereotype.Component;

import com.prac.transaction.service.ProductService;

@Component
public class RepeatableRead {

    private final ProductService productService;

    public RepeatableRead(ProductService productService) {
        this.productService = productService;
    }

    public void testReadCommitted(int id) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                productService.updateStock(id, 5);
               } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(2000);
                int stock = productService.fetchStock(id);
                System.out.println("Stock read by transaction B: " + stock);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();

         threadA.join();
        threadB.join();

    }

}
