package com.banco.banco.business;

import java.util.List;
import java.util.Optional;

import com.banco.banco.controller.request.OriginCommerceRequest;
import com.banco.banco.controller.response.ApiResponseDefault;
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

	@Transactional
	public ApiResponseDefault clientPay (OriginCommerceRequest originCommerceRequest){

		ApiResponseDefault apiResponseDefault = new ApiResponseDefault();

		try{

			Cliente cliente = clienteDao.findByIdentificacion(originCommerceRequest.getNumeroDocumento());

			if(cliente == null){

				cliente = new Cliente();
				cliente.setIdentificacion(originCommerceRequest.getNumeroDocumento());
				cliente.setPer_nombre(originCommerceRequest.getNombreComprador());
				cliente.setPer_numero_celular(Integer.parseInt(originCommerceRequest.getNumeroCelular()));
				clienteDao.save(cliente);

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

}
