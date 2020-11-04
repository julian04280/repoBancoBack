package com.banco.banco.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.*;
import com.banco.banco.persistence.repository.CuentaDao;


@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	CuentaDao cuentaDao;
	
	@Override
	@Transactional(readOnly = true )
	public List<Cuenta> findAll() {
		
		return cuentaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true )
	public List<Cuenta> findByIdCliente(String clienteId) {
		
		return cuentaDao.findByClienteId(clienteId);
	}

	@Override
	@Transactional(readOnly = true )
	public Cuenta findById(String id) {
		
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cuenta  save(Cuenta cuenta) {
		

		if(! cuentaDao.existsById(cuenta.getCodCuenta())) {
			return cuentaDao.save(cuenta);
		}
		 return null;
		
		
	}
	
	@Override
	@Transactional
	public Cuenta  update(Cuenta cuenta) {
		
		return cuentaDao.save(cuenta);
	}

	@Override
	@Transactional
	public void delete(String id) {
		
		 cuentaDao.deleteById(id);
	}

}
