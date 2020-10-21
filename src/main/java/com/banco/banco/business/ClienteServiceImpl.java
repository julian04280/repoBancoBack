package com.banco.banco.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.Cliente;
import com.banco.banco.persistence.repository.ClienteDao;
import com.banco.banco.controller.modelRequest.LoginRequest;
import com.banco.banco.controller.modelResponse.LoginResponse;

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
	
	@Override
	@Transactional
	public LoginResponse consultLogin(LoginRequest login) {
		
		LoginResponse loginResponse = new LoginResponse();
		Cliente cliente = clienteDao.findById(login.getIdentication()).orElse(null);
		
		if(cliente != null) {
			if(cliente.getPer_clave().equals(login.getPassLogin())) {
				loginResponse.setPer_identificacion(cliente.getPer_identificacion());
				loginResponse.setPer_nombre(cliente.getPer_nombre());
				loginResponse.setPer_apellido(cliente.getPer_apellido());
				loginResponse.setBanco_identificacion(cliente.getBanco().getBanco_identificacion());
				loginResponse.setBanco_llave(cliente.getBanco().getBanco_llave());
				loginResponse.setBanco_nombre(cliente.getBanco().getBanco_nombre());
				loginResponse.setBanco_logo(cliente.getBanco().getBanco_logo());
				loginResponse.setRol_identificacion(cliente.getRoles().get(0).getRol_identificacion());
				loginResponse.setRol_nombre(cliente.getRoles().get(0).getRol_nombre());
				loginResponse.setMenssage("ok");
				return loginResponse;
			}
			else {
				loginResponse.setRol_identificacion(1);
				loginResponse.setMenssage("Contraseña incorrecta");
				return loginResponse;
			}
		}
		else {
			loginResponse.setRol_identificacion(1);
			loginResponse.setMenssage("Usuario no encontrado");
			return loginResponse;
		}
	}
}
