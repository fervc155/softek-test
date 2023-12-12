package com.example.villanuevac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.villanuevac.repository.DireccionRepository;


import com.example.villanuevac.DTO.Direccion;

@Service
public class DireccionService {
	
	@Autowired
	private DireccionRepository direccionR;

	
	public List<Direccion> all()
	{
		return this.direccionR.findAll();
	}
	
	public Direccion store(Direccion direccionData)
	{		
		return this.direccionR.save(direccionData);
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
