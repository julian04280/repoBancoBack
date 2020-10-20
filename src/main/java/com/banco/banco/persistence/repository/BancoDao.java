package com.banco.banco.persistence.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Banco;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
@EntityScan(basePackages = "com.banco.banco.persistence.entity")
public interface BancoDao extends JpaRepository<Banco, Integer> {

}
