package com.banco.banco.business;

import java.util.List;

import com.banco.banco.controller.request.CreateTransactionRequest;
import com.banco.banco.controller.response.CreateTransactionResponse;
import com.banco.banco.persistence.entity.Banco;

public interface BancoService {
	
	List<Banco> findAll();
	
	Banco findById(Integer id);
	
	Banco save(Banco banco);
	
	void delete(Integer id);

	CreateTransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest);
}
