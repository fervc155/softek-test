package com.example.villanuevac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.villanuevac.repository.DireccionRepository;
import com.example.villanuevac.DTO.Cuenta;
import com.example.villanuevac.DTO.Direccion;
import com.example.villanuevac.DTO.Usuario;

@Service
public class DireccionService {
	
	@Autowired
	private DireccionRepository direccionR;

	@Autowired
	private UsuarioService usuarioS;

	
	public List<Direccion> all()
	{
		return this.direccionR.findAll();
	}
	
	public Direccion store(Direccion direccionData)
	{		
		return this.direccionR.save(direccionData);
	}
	public Direccion storeByUser(Integer id, Direccion direccionData) throws Exception
	{		
		Usuario usuario = this.usuarioS.show(id);
		direccionData.setUsuario(usuario);
		return this.direccionR.save(direccionData);
	}
	
	public List<Direccion> showByUser(Integer id) throws Exception
	{	
		Usuario usuario=this.usuarioS.show(id);	
		return usuario.getDirecciones();
	}
	
	public Direccion show(Integer id) throws Exception
	{	
		Direccion direccion =this.direccionR.findById(id).orElse(null);	
		
		if(direccion==null){
			throw new Exception("Direccion no encontrada");
		}

		return direccion;
	}
	
	public Direccion update(Integer id, Direccion direccionData) throws Exception
	{		
		Direccion direccion = this.show(id);
		direccion.replace(direccionData);
		return this.direccionR.save(direccion);
	}
	
	
	public void delete(Integer id) throws Exception
	{		
		Direccion direccion = this.show(id);
		this.direccionR.delete(direccion);
	}
}
