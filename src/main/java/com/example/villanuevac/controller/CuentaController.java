package com.example.villanuevac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.villanuevac.DTO.Cuenta;
import com.example.villanuevac.service.CuentaService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping
	public List<Cuenta> index() {
		return this.cuentaService.all();
	}
	@GetMapping(value="/{id}")
	public Cuenta show(@PathVariable("id") Integer id) throws Exception {
		return this.cuentaService.show(id);
	}
	
	@GetMapping(value="/usuario/{id}")
	public List<Cuenta> showByUser(@PathVariable("id") Integer id) throws Exception {
		return this.cuentaService.showByUser(id);
	}
	
	@PostMapping(value="/usuario/{id}")
	public Cuenta store(@PathVariable("id") Integer id, @Valid @RequestBody Cuenta cuenta) throws Exception {
		return this.cuentaService.storeByUser(id, cuenta);
	}
	@PostMapping
	public Cuenta store(@Valid @RequestBody Cuenta cuenta) {
		return this.cuentaService.store(cuenta);
	}

	
	
	@PutMapping(value="/{id}")
	public Cuenta update(@PathVariable("id") Integer id, @Valid @RequestBody Cuenta cuenta) throws Exception {
		return this.cuentaService.update(id, cuenta);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String  update(@PathVariable("id") Integer id) throws Exception {
		this.cuentaService.delete(id);
		 return "Cuenta borrada correctamente";
	}
}
