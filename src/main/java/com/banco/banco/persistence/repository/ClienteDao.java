package com.banco.banco.persistence.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
@EntityScan(basePackages = "com.banco.banco.persistence.entity")
public interface ClienteDao extends JpaRepository<Cliente, String>{

    Cliente findByIdentificacion(String identification);
}
