package com.banco.banco.business;

import java.util.List;

import com.banco.banco.controller.request.OriginCommerceRequest;
import com.banco.banco.controller.response.ApiResponseDefault;
import com.banco.banco.persistence.entity.Cliente;


public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(String id);
	
	public Cliente save(Cliente banco);
	
	public void delete(String id);

	ApiResponseDefault clientPay (OriginCommerceRequest originCommerceRequest);

}
