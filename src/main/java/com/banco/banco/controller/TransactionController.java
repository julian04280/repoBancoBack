package com.banco.banco.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.banco.business.TransactionService;
import com.banco.banco.persistence.entity.Transaction;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	// Create
	@PostMapping("/transaction")
	public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
		Transaction transaction2 = null;
		try {
			transaction2 = transactionService.save(transaction);

			return ResponseEntity.status(HttpStatus.OK).body(transaction2);

		} catch (Exception ex) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(transaction2);
		}

	}

	// Real all
	@GetMapping("/transaction")
	public ResponseEntity<List<Transaction>> show() {
		List<Transaction> transactions = transactionService.findAll();
		if (!transactions.isEmpty()) {
			// return ResponseEntity.ok(transactions);
			return ResponseEntity.status(HttpStatus.OK).body(transactions);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Read by id
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> read(@PathVariable Integer id) {
		Transaction transaction = transactionService.findById(id);

		if (transaction != null) {
			// return ResponseEntity.ok(transaction);
			return ResponseEntity.status(HttpStatus.OK).body(transaction);

		} else {
			// return ResponseEntity.notFound().build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Update
	@PutMapping("/transaction")
	public ResponseEntity<Transaction> update(@RequestBody Transaction transaction) {
		Transaction transaction2 = transactionService.findById(transaction.getTransactionIdentificacion());

		if (transaction2 != null) {
			BeanUtils.copyProperties(transaction, transaction2);
			return ResponseEntity.ok(transactionService.save(transaction2));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(transaction);
		}
	}

	// Delete
	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<Transaction> delete(@PathVariable Integer id) {
		Transaction transaction = transactionService.findById(id);
		if (transaction != null) {
			transactionService.delete(id);
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}

	}

}