package com.banco.banco.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco.persistence.entity.Rol;

public interface RolDao extends JpaRepository<Rol, Integer> {

}
