package com.hari.serverproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hari.serverproductmanagement.model.Transaction;
import com.hari.serverproductmanagement.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Long numberOfTransactions() {
		return transactionRepository.count();
	}

	@Override
	public List<Transaction> findAllTransactions() {
		return transactionRepository.findAll();
	}

}
