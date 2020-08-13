package com.hari.serverproductmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.serverproductmanagement.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
