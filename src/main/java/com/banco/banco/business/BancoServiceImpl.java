package com.banco.banco.business;

import java.util.List;

import com.banco.banco.controller.modelRequest.CreateTransactionRequest;
import com.banco.banco.controller.modelResponse.CreateTransactionResponse;
import com.banco.banco.persistence.entity.Cuenta;
import com.banco.banco.persistence.entity.Transaction;
import com.banco.banco.persistence.repository.CuentaDao;
import com.banco.banco.persistence.repository.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.Banco;
import com.banco.banco.persistence.repository.BancoDao;

@Service
public class BancoServiceImpl implements BancoService {

	@Autowired
	private BancoDao bancoDao;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private CuentaDao cuentaDao;

	@Transactional(readOnly = true)
	public List<Banco> findAll() {
		return bancoDao.findAll();
	}

	@Transactional(readOnly = true)
	public Banco findById(Integer id) {
		return bancoDao.findById(id).orElse(null);
	}

	@Transactional
	public Banco save(Banco banco) {
		return bancoDao.save(banco);
	}

	@Transactional
	public void delete(Integer id) {
		bancoDao.deleteById(id);
	}

	@Transactional(rollbackFor = {RuntimeException.class})
	public CreateTransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest) {

		CreateTransactionResponse createTransactionResponse = new CreateTransactionResponse();

		try{

			//Para Crear una transaccion se debe tener registrado la cuenta y el comercio en el banco
			Transaction transaction = new Transaction();
			transaction.setFecha(createTransactionRequest.getFecha());
			transaction.setMonto(createTransactionRequest.getMonto());
			transaction.setDescripcion(createTransactionRequest.getDescripcion());
			transaction.setEstado("CREADA");
			transaction.setCuentaRecaudador(createTransactionRequest.getCuentaRecaudador());

			Cuenta cuenta = cuentaDao.findById(createTransactionRequest.getCuenta()).orElse(null);
			if(cuenta == null){
				throw new RuntimeException("Codigo Cuenta Incorrecto");
			}

			transaction.setIdCuenta(cuenta.getCodCuenta());

			transactionDao.save(transaction);
			createTransactionResponse.setCodigoEstado("200");
			createTransactionResponse.setEstado("CREADA");
			createTransactionResponse.setDescripcionEstado("Transacción creada correctamente");
			createTransactionResponse.setUrlRedirigir(createTransactionRequest.getUrlRetorno() + "/" + transaction.getTransactionIdentificacion());
			createTransactionResponse.setLifetimeSecs("60");
			createTransactionResponse.setIdTransaccion(String.valueOf(transaction.getTransactionIdentificacion()));

		}catch (RuntimeException e){

			createTransactionResponse.setCodigoEstado("400");
			createTransactionResponse.setDescripcionEstado("Error en la creacion de la transaccion " + e.getMessage());

		}

		return createTransactionResponse;
	}

}
