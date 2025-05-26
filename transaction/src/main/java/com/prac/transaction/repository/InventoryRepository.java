package com.prac.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac.transaction.entity.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {


}
