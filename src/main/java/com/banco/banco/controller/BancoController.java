package com.banco.banco.controller;

import java.util.List;

import com.banco.banco.controller.modelRequest.CreateTransactionRequest;
import com.banco.banco.controller.modelResponse.CreateTransactionResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.banco.business.BancoService;
import com.banco.banco.persistence.entity.Banco;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("api")
public class BancoController {

	@Autowired
	BancoService bancoService;

	// Create
	@PostMapping("/banco")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Banco> create(@RequestBody Banco banco) { // Lo que viene en json se parcea rol
		// Devuelve 201 si se creo exitosamente
		return ResponseEntity.status(HttpStatus.CREATED).body(bancoService.save(banco));
	}

	// Read all
	@GetMapping("/banco")
	public ResponseEntity<List<Banco>> show() {
		List<Banco> bancos = bancoService.findAll();

		if (!bancos.isEmpty()) {
			return ResponseEntity.ok(bancos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Read by id
	@GetMapping("banco/{id}")
	public ResponseEntity<Banco> read(@PathVariable Integer id) {
		Banco banco = bancoService.findById(id);

		if (banco != null) {
			return ResponseEntity.ok(banco);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update
	@PutMapping("/banco")
	public ResponseEntity<Banco> update(@RequestBody Banco banco) {
		Banco banco2 = bancoService.findById(banco.getBancoIdentificacion());

		if (banco2 != null) {
			BeanUtils.copyProperties(banco, banco2);
			return ResponseEntity.ok(bancoService.save(banco2));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete
	@DeleteMapping("/banco/{id}")
	public ResponseEntity<Banco> delete(@PathVariable Integer id) {
		Banco banco = bancoService.findById(id);
		if (banco != null) {
			bancoService.delete(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Create
	@PostMapping("/banco/crearTransaccion")
	@ResponseBody
	public CreateTransactionResponse create(@RequestBody CreateTransactionRequest createTransactionRequest) {
		return bancoService.createTransaction(createTransactionRequest);
	}
}
