package com.banco.banco.persistence.repository;

import com.banco.banco.persistence.entity.Comercio;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
@EntityScan(basePackages = "com.banco.banco.persistence.entity")
public interface ComercioDao extends JpaRepository<Comercio, Integer> {

    Comercio findByRefComercio(String refComercio);
}
