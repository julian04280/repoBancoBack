package com.banco.banco.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, String>{

}
