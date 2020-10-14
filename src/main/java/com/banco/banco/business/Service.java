package com.banco.banco.business;

import java.util.List;

import com.banco.banco.persistence.entity.Rol;

public interface Service<T> {

	public List<T> findAll();

	public T findById(Integer id);

	public T save(Rol rol);

	public void delete(Integer id);
}
