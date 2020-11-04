package com.banco.banco.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Banco;

public interface BancoDao extends JpaRepository<Banco, Integer> {

}
