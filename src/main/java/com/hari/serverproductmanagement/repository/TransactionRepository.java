package com.hari.serverproductmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.serverproductmanagement.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
