package com.banco.banco.controller;

import java.util.List;

import com.banco.banco.controller.request.CreateTransactionRequest;
import com.banco.banco.controller.request.OriginCommerceRequest;
import com.banco.banco.controller.response.ApiResponseDefault;
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
import com.banco.banco.persistence.entity.Cliente;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("api")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// Create
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	// Read all
	@GetMapping("/cliente")
	public ResponseEntity<List<Cliente>> show() {
		List<Cliente> clientes = clienteService.findAll();

		if (!clientes.isEmpty()) {
			return ResponseEntity.ok(clientes);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Read by id
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> read(@PathVariable String id) {
		Cliente cliente = clienteService.findById(id);

		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update
	@PutMapping("/cliente")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		Cliente cliente2 = clienteService.findById(cliente.getIdentificacion());

		if (cliente2 != null) {
			BeanUtils.copyProperties(cliente, cliente2);
			return ResponseEntity.ok(clienteService.save(cliente2));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable String id) {
		Cliente cliente = clienteService.findById(id);
		if (cliente != null) {
			clienteService.delete(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/clientePaga")
	public ApiResponseDefault clientPay(@RequestBody OriginCommerceRequest originCommerceRequest) {
		return clienteService.clientPay(originCommerceRequest);
	}
}
