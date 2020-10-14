package com.banco.banco.controller;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.banco.business.RolService;

import com.banco.banco.persistence.entity.Rol;

@CrossOrigin(origins = { "*" })
@RestController
//@RequestMapping("api")
@RequestMapping("api")
public class RolController {

	@Autowired
	RolService rolService;

	// Create
	@PostMapping("/rol")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Rol> create(@RequestBody Rol rol) { // Lo que viene en json se parcea rol

		// Rol rol2 = rolService.save(rol);
		// return ResponseEntity.ok(rolService.save(rol));
		// Devuelve 201 si se creo exitosamente
		return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol));
	}

	// Read all
	@GetMapping("/rol")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Rol>> show() {

		List<Rol> roles = rolService.findAll();

		if (!roles.isEmpty()) {
			return ResponseEntity.ok(roles);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	// Read by id
	@GetMapping("/rol/{id}")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Rol> read(@PathVariable Integer id) {
		Rol rol = rolService.findById(id);

		if (rol != null) {
			return ResponseEntity.ok(rol);
		} else {
			// Devuelve 404 si no lo encuentra
			return ResponseEntity.notFound().build();
		}
	}

	// Update
	@PutMapping("/rol")
	public ResponseEntity<Rol> update(@RequestBody Rol rol) {
		// Buscar ese usuario por id
		Rol rol2 = rolService.findById(rol.getRol_identificacion());

		if (rol2 != null) {
			BeanUtils.copyProperties(rol, rol2);
			//rol2.setRol_nombre(rol.getRol_nombre());
			// Se guarda el usuario actualizado
			return ResponseEntity.ok(rolService.save(rol2));

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete
	@DeleteMapping("/rol/{id}")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Rol> delete (@PathVariable Integer id) {
		Rol rol = rolService.findById(id);
		if (rol != null) {
			rolService.delete(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
