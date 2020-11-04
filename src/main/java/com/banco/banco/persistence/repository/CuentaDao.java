package com.banco.banco.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, String>{

}
