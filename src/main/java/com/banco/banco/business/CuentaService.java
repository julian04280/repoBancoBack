package com.banco.banco.business;

import java.util.List;

import com.banco.banco.persistence.entity.*;

public interface CuentaService {
	
	List<Cuenta> findAll();
	
	List<Cuenta> findByIdCliente(String clienteId);
	
	Cuenta findById(String id);
	
	Cuenta save(Cuenta banco);
	
	Cuenta  update(Cuenta cuenta);
	
	void delete(String id);


}
