package com.banco.banco.business;

import java.util.List;

import com.banco.banco.persistence.entity.Rol;

public interface RolService {
	
	public List<Rol> findAll();
	
	public  Rol findById(Integer id);
	
	public  Rol save(Rol rol);
	
	public void delete(Integer id); 

}
