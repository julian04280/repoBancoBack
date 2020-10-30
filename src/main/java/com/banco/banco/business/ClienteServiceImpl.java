package com.banco.banco.business;

import java.util.List;

import com.banco.banco.controller.modelRequest.OriginCommerceRequest;
import com.banco.banco.controller.modelResponse.ApiResponseDefault;
import com.banco.banco.persistence.entity.Rol;
import com.banco.banco.persistence.repository.RolDao;
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

	@Autowired
	private RolDao rolDao;

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

	@Transactional
	public ApiResponseDefault clientPay (OriginCommerceRequest originCommerceRequest){

		ApiResponseDefault apiResponseDefault = new ApiResponseDefault();

		try{

			Cliente cliente = clienteDao.findByIdentificacion(originCommerceRequest.getNumeroCedula());

			if(cliente == null){
				throw new RuntimeException("Cliente no encontrado");
			}

			apiResponseDefault.setCodStatus("200");
			apiResponseDefault.setDescription("Se valida Cliente que va a pagar en el sistema");
			apiResponseDefault.setStatus("OK");

		}catch (RuntimeException e){

			apiResponseDefault.setCodStatus("400");
			apiResponseDefault.setDescription(e.getMessage());
			apiResponseDefault.setStatus("ERROR");
		}

		return apiResponseDefault;
	}


	@Override
	@Transactional
	public LoginResponse consultLogin(LoginRequest login) {

		LoginResponse loginResponse = new LoginResponse();
		Cliente cliente = clienteDao.findById(login.getIdentication()).orElse(null);

		if(cliente != null) {
			if(cliente.getClave().equals(login.getPassLogin())) {
				loginResponse.setIdentificacion(cliente.getIdentificacion());
				loginResponse.setNombre(cliente.getNombre());
				loginResponse.setApellido(cliente.getApellido());
				loginResponse.setBancoIdentificacion(cliente.getBanco().getBancoIdentificacion());
				loginResponse.setBancoLlave(cliente.getBanco().getBancoLlave());
				loginResponse.setBancoNombre(cliente.getBanco().getBancoNombre());
				loginResponse.setBancoLogo(cliente.getBanco().getBancoLogo());
				loginResponse.setRoles(cliente.getRoles());
				loginResponse.setMenssage("ok");
				return loginResponse;
			}
			else {
				loginResponse.setMenssage("Contraseña incorrecta");
				return loginResponse;
			}
		}
		else {
			loginResponse.setMenssage("Usuario no encontrado");
			return loginResponse;
		}
	}
}
