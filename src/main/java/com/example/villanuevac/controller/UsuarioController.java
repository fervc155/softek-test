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

import com.example.villanuevac.DTO.Usuario;
import com.example.villanuevac.service.UsuarioService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> index() {
		return this.usuarioService.all();
	}
	@GetMapping(value="/{id}")
	public Usuario show(@PathVariable("id") Integer id) throws Exception {
		return this.usuarioService.show(id);
	}
	
	@PostMapping
	public Usuario store(@Valid @RequestBody Usuario usuario) {
		return this.usuarioService.store(usuario);
	}

	
	@PutMapping(value="/{id}")
	public Usuario update(@PathVariable("id") Integer id, @Valid @RequestBody Usuario usuario) throws Exception {
		return this.usuarioService.update(id, usuario);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String  update(@PathVariable("id") Integer id) throws Exception {
		this.usuarioService.delete(id);
		 return "Usuario borrada correctamente";
	}
}
