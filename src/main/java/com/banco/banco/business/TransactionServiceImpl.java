package com.banco.banco.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.Transaction;
import com.banco.banco.persistence.repository.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Transaction> findAll() {
		return transactionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Transaction findById(Integer id) {
		return transactionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public Transaction update(Transaction transaction) {
		if(!transactionDao.existsById(transaction.getTransactionIdentificacion())) {
			return transactionDao.save(transaction);
		}
		 return null;
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		transactionDao.deleteById(id);
	}

	@Override
	@Transactional
	public Transaction recepcion(Integer id) {
		return transactionDao.findById(id).orElse(null);
	}
}
