package com.example.assignment2.repository;

import com.example.assignment2.model.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemsRepository extends JpaRepository<ProductItems,Long> {
}
