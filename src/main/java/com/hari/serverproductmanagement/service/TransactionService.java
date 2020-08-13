package com.hari.serverproductmanagement.service;

import java.util.List;

import com.hari.serverproductmanagement.model.Transaction;

public interface TransactionService {
	
	Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();

}
