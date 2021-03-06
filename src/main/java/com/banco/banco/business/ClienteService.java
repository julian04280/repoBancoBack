package com.banco.banco.business;

import java.util.List;

import com.banco.banco.controller.modelRequest.OriginCommerceRequest;
import com.banco.banco.controller.modelResponse.ApiResponseDefault;
import com.banco.banco.controller.modelRequest.LoginRequest;
import com.banco.banco.controller.modelResponse.LoginResponse;
import com.banco.banco.persistence.entity.Cliente;


public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(String id);
	
	public Cliente save(Cliente banco);
	
	public void delete(String id);

	public LoginResponse consultLogin(LoginRequest login);

	ApiResponseDefault clientPay (OriginCommerceRequest originCommerceRequest);

}
