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
import com.example.villanuevac.DTO.Direccion;
import com.example.villanuevac.service.DireccionService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

	@Autowired
	private DireccionService direccionService;
	
	@GetMapping
	public List<Direccion> index() {
		return this.direccionService.all();
	}
	@GetMapping(value="/{id}")
	public Direccion show(@PathVariable("id") Integer id) throws Exception {
		return this.direccionService.show(id);
	}
	
	@PostMapping
	public Direccion store(@Valid @RequestBody Direccion direccion) {
		return this.direccionService.store(direccion);
	}

	@PostMapping(value="/usuario/{id}")
	public Direccion store(@PathVariable("id") Integer id, @Valid @RequestBody Direccion direccion) throws Exception {
		return this.direccionService.storeByUser(id, direccion);
	}	
	@GetMapping(value="/usuario/{id}")
	public List<Direccion> showByUser(@PathVariable("id") Integer id) throws Exception {
		return this.direccionService.showByUser(id);
	}
	
	@PutMapping(value="/{id}")
	public Direccion update(@PathVariable("id") Integer id, @Valid @RequestBody Direccion direccion) throws Exception {
		return this.direccionService.update(id, direccion);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String  update(@PathVariable("id") Integer id) throws Exception {
		this.direccionService.delete(id);
		 return "Direccion borrada correctamente";
	}
}
