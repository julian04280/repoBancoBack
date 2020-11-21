package com.banco.banco.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.banco.business.ClienteService;
import com.banco.banco.business.CuentaService;
import com.banco.banco.business.TransactionService;
import com.banco.banco.persistence.entity.Cliente;
import com.banco.banco.persistence.entity.Cuenta;
import com.banco.banco.persistence.entity.Transaction;
import com.banco.banco.persistence.repository.CuentaDao;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("api")
public class TransactionController {

	// String url = "http://nodocursoiot.ml:7777/com.banco-1/api/login/";
	String url = "http://nodocursoiot.ml:7777/angular/login/";
	LocalDate date = LocalDate.now();

	@Autowired
	TransactionService transactionService;
	// ---------------------------------------------------------------------------
	@Autowired
	CuentaService cuentaservice;
	// -----------------------------------------------------------------------------

	@Autowired
	ClienteService clienteService;

	// Create
	@PostMapping("/transaction")
	public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
		Transaction transaction2 = new Transaction();

		try {

			transaction.setEstado("CREADO");
			transaction.setFecha(date);

			System.out.println("Fechas: " + date);
			transaction2 = transactionService.save(transaction);

			// Modifica el url con el id
			transaction2.setUrlRetorno(url + transaction2.getTransactionIdentificacion());

			update(transaction2);

			return ResponseEntity.status(HttpStatus.OK).body(transaction2);

		} catch (Exception ex) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(transaction2);
		}

	}

	// Real all
	@GetMapping("/transaction")
	public ResponseEntity<List<Transaction>> show() {
		List<Transaction> transactions = transactionService.findAll();
		if (!transactions.isEmpty()) {
			// return ResponseEntity.ok(transactions);
			return ResponseEntity.status(HttpStatus.OK).body(transactions);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Read by id
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> read(@PathVariable Integer id) {
		Transaction transaction = transactionService.findById(id);

		if (transaction != null) {
			// return ResponseEntity.ok(transaction);
			return ResponseEntity.status(HttpStatus.OK).body(transaction);

		} else {
			// return ResponseEntity.notFound().build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Update
	@PutMapping("/transaction")
	public ResponseEntity<Transaction> update(@RequestBody Transaction transaction) {
		Transaction transaction2 = transactionService.findById(transaction.getTransactionIdentificacion());

		if (transaction2 != null) {
			BeanUtils.copyProperties(transaction, transaction2);
			return ResponseEntity.ok(transactionService.save(transaction2));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(transaction);
		}
	}

	// Delete
	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<Transaction> delete(@PathVariable Integer id) {
		Transaction transaction = transactionService.findById(id);
		if (transaction != null) {
			transactionService.delete(id);
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/transaction/validacion")
	public ResponseEntity<Transaction> receppago(@RequestBody Transaction trans) {
		update(trans);
		Transaction transaction = transactionService.findById(trans.getTransactionIdentificacion());
		Cuenta cuenta = cuentaservice.findById(transaction.getIdCuenta());

		if (transaction != null && cuenta.getValor() >= transaction.getMonto()) {
			// return ResponseEntity.ok(transaction);

			cuenta.setValor(cuenta.getValor() - transaction.getMonto());
			cuentaservice.update(cuenta);
			transaction.setEstado("Aprobado");
			update(transaction);
			return ResponseEntity.status(HttpStatus.OK).body(transaction);

		} else {
			// return ResponseEntity.notFound().build();
			transaction.setEstado("Denegada");
			update(transaction);
			return ResponseEntity.status(HttpStatus.OK).body(transaction);
		}

	}

	@PutMapping("/transaction/abono")
	public ResponseEntity<Transaction> abonoCuenta(@RequestBody Transaction transaction) {
		Transaction transaction2 = null;

		if (transaction.getTipoTransaccion() == 2) {
			transaction2 = transaction;

			// Se trae la cuenta de acuerdo al id de la cuenta recaudadora
			Cuenta cuenta = cuentaservice.findById(transaction2.getCuentaRecaudador());

			// Valido que la cuenta exista
			if (cuenta != null) {
				Cliente cliente = clienteService.findById(cuenta.getClienteId());
				// Valido que el cliente exista

				if (cliente != null) {
					// Hay un cliente y una cuenta
					cuenta.setValor(cuenta.getValor() + transaction2.getMonto());
					transaction2.setFecha(date);
					transaction2.setEstado("APROBADO");
					transaction2.setIdCuenta(cuenta.getCodCuenta());
					cuentaservice.update(cuenta);
					transactionService.save(transaction2);

					return ResponseEntity.status(HttpStatus.OK).body(transaction2);
				} else {
					transaction2.setEstado("DENEGADO");
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(transaction2);
				}

			} else {
				transaction2.setEstado("DENEGADO");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(transaction2);

			}
		} else {
			transaction.setEstado("DENEGADO");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(transaction);
		}

	}

}
