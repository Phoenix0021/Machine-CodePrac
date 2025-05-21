package com.vendingmachine;

import com.vendingmachine.model.Product;
import com.vendingmachine.model.PaymentMethod;
import com.vendingmachine.service.*;
import com.vendingmachine.utility.IdGenerator;

import java.util.Scanner;

public class VendingMachineApp {

 
        public void run(){

        InventoryService inventoryService = new InventoryServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();

        VendingMachineService vendingMachineService = new VendingMachineServiceImpl(
                inventoryService, paymentService, transactionService);

        // Add sample products with generated IDs
        Product p1 = new Product(IdGenerator.generateId(), "Coke", 50, 10);
        Product p2 = new Product(IdGenerator.generateId(), "Pepsi", 45, 8);
        Product p3 = new Product(IdGenerator.generateId(), "Water", 20, 15);

        inventoryService.addProduct(p1);
        inventoryService.addProduct(p2);
        inventoryService.addProduct(p3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Vending Machine ---");
            vendingMachineService.displayProducts();

            System.out.print("Enter product ID to select (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting. Thanks!");
                break;
            }

            if (!vendingMachineService.selectProduct(input)) {
                System.out.println("Invalid or unavailable product. Try again.");
                continue;
            }

            Product selectedProduct = inventoryService.getProduct(input);
            System.out.println("Selected: " + selectedProduct.getProductName() +
                    " Price: " + selectedProduct.getPrice());

            System.out.print("Enter payment amount: ");
            int amount = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter payment method (CASH, CARD, QR): ");
            String methodInput = scanner.nextLine();
            PaymentMethod method;

            try {
                method = PaymentMethod.valueOf(methodInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid payment method. Try again.");
                continue;
            }

            boolean success = vendingMachineService.makePaymentAndDispense(input, amount, method);
            if (!success) {
                System.out.println("Transaction failed. Please try again.");
            }
        }

        scanner.close();
    }
}

