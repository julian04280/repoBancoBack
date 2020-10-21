package com.banco.banco.business;

import java.util.List;

import com.banco.banco.controller.modelRequest.CreateTransactionRequest;
import com.banco.banco.controller.modelResponse.CreateTransactionResponse;
import com.banco.banco.persistence.entity.Banco;

public interface BancoService {
	
	List<Banco> findAll();
	
	Banco findById(Integer id);
	
	Banco save(Banco banco);
	
	void delete(Integer id);

	CreateTransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest);
}
