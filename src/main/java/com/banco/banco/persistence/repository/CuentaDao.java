package com.banco.banco.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, String>{
    
	List<Cuenta> findByClienteId(String clienteId);
}
