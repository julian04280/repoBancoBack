package com.banco.banco.business;

import java.util.List;

import com.banco.banco.persistence.entity.Transaction;

public interface TransactionService {

	public List<Transaction> findAll();

	public Transaction findById(Integer id);

	public Transaction save(Transaction transaction);
	
	public Transaction update(Transaction transaction);
	
	public void delete(Integer id);

}
