package com.banco.banco.business;

import java.util.List;

import com.banco.banco.persistence.entity.Banco;

public interface BancoService {
	
	public List<Banco> findAll();
	
	public Banco findById(Integer id);
	
	public Banco save(Banco banco);
	
	public void delete(Integer id);

}
