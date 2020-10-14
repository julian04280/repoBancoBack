package com.banco.banco.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.Cliente;
import com.banco.banco.persistence.repository.ClienteDao;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(String id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente banco) {
		return clienteDao.save(banco);
	}

	@Override
	@Transactional
	public void delete(String id) {
		clienteDao.deleteById(id);
	}
}
