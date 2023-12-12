package com.example.villanuevac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.villanuevac.repository.UsuarioRepository;


import com.example.villanuevac.DTO.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioR;

	
	public List<Usuario> all()
	{
		return this.usuarioR.findAll();
	}
	
	public Usuario store(Usuario usuarioData)
	{		
		return this.usuarioR.save(usuarioData);
	}
	
	public Usuario show(Integer id) throws Exception
	{	
		Usuario usuario =this.usuarioR.findById(id).orElse(null);	
		
		if(usuario==null){
			throw new Exception("Usuario no encontrada");
		}

		return usuario;
	}
	
	public Usuario update(Integer id, Usuario usuarioData) throws Exception
	{		
		Usuario usuario = this.show(id);
		usuario.replace(usuarioData);
		return this.usuarioR.save(usuario);
	}
	
	
	public void delete(Integer id) throws Exception
	{		
		Usuario usuario = this.show(id);
		this.usuarioR.delete(usuario);
	}
}
