package com.banco.banco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.banco.banco.business.CuentaService;
import com.banco.banco.persistence.entity.Cuenta;



@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("api")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	private static final String OBJBASE  = "cuenta";
	private static final String MJS_REST = "mensaje";
	
	@GetMapping("/cuenta")
	public ResponseEntity<List<Cuenta> > show(){
		
		List<Cuenta> cuentas = cuentaService.findAll();
		return (!cuentas.isEmpty()) ? ResponseEntity.ok(cuentas): ResponseEntity.notFound().build();		
	}
	
	@GetMapping("/cuenta/cliente/{clienteId}")
	public ResponseEntity<List<Cuenta> > showIdCuentaCliente(@PathVariable String clienteId){
		
		List<Cuenta> cuentas = cuentaService.findByIdCliente(clienteId);
		return (!cuentas.isEmpty()) ? ResponseEntity.ok(cuentas): ResponseEntity.notFound().build();		
	}
	
	@GetMapping("/cuenta/{id}")
	public ResponseEntity<?> read(@PathVariable String id){
		
		Cuenta cuenta =  cuentaService.findById(id);
		Map<String, Object> response = new HashMap<>();
		if(cuenta != null ) {
			response.put(OBJBASE, cuenta);
			response.put(MJS_REST, "cuenta encontrada");		
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}else {
			response.put(OBJBASE, new Cuenta());
			response.put(MJS_REST, " no se encuentra Id: "+id );
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
	}
	
	
	@PostMapping("/cuenta")
	public ResponseEntity<?> create(@Valid
			                        @RequestBody Cuenta cuenta,
			                        BindingResult result){
		Cuenta cuentaNew = null ;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			String errors = "";
			for(ObjectError er :result.getAllErrors()) {
				 errors = errors +er.getDefaultMessage();
			}
	    	 response.put(MJS_REST,errors );
	     }
		try {
			cuentaNew = cuentaService.save(cuenta);
			if(cuentaNew != null) {
				response.put(OBJBASE, cuentaNew);
				response.put(MJS_REST, "cuenta creada con exito");
			    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			}else {
				response.put(OBJBASE, cuenta);
				response.put(MJS_REST, "el id ya existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST); 
			}				               
		}catch(Exception ex) {
			response.put(OBJBASE, cuenta);
			response.put(MJS_REST, ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST); 
		}
	} 
		
	@PutMapping("/cuenta")
	public ResponseEntity<?> update(@RequestBody Cuenta cuenta){
		Cuenta cuentaNew = null ;
		Map<String, Object> response = new HashMap<>();
		try {
			cuentaNew = cuentaService.update(cuenta);
			response.put(OBJBASE, cuentaNew);
			response.put(MJS_REST, "cuenta actualizada  con exito!");
		    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}catch(Exception ex) {
			response.put(OBJBASE, new Cuenta());
			response.put(MJS_REST, ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST); 
		}
	} 
	
	@DeleteMapping("/cuenta/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		Map<String, Object> response = new HashMap<>();
		try {
			 cuentaService.delete(id);	
			 response.put(MJS_REST, "cuenta borrada con exito");
		}catch(Exception ex) {
			response.put(MJS_REST, ex.getMessage()); 
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
	    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


}
