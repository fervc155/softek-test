package com.example.villanuevac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.villanuevac.repository.CuentaRepository;
import com.example.villanuevac.repository.UsuarioRepository;
import com.example.villanuevac.DTO.Cuenta;
import com.example.villanuevac.DTO.Usuario;

@Service
public class CuentaService {
	
	@Autowired
	private CuentaRepository cuentaR;

	@Autowired
	private UsuarioService usuarioS;

	public List<Cuenta> all()
	{
		return this.cuentaR.findAll();
	}
	
	public Cuenta store(Cuenta cuentaData)
	{		
		return this.cuentaR.save(cuentaData);
	}
	
	
	public Cuenta storeByUser(Integer id, Cuenta cuentaData) throws Exception
	{		
		Usuario usuario = this.usuarioS.show(id);
		cuentaData.setUsuario(usuario);
		return this.cuentaR.save(cuentaData);
	}
	
	
	public Cuenta show(Integer id) throws Exception
	{	
		Cuenta cuenta =this.cuentaR.findById(id).orElse(null);	
		
		if(cuenta==null){
			throw new Exception("Cuenta no encontrada");
		}

		return cuenta;
	}
	public List<Cuenta> showByUser(Integer id) throws Exception
	{	
		Usuario usuario=this.usuarioS.show(id);	
		
		

		return usuario.getCuentas();
	}
	
	public Cuenta update(Integer id, Cuenta cuentaData) throws Exception
	{		
		Cuenta cuenta = this.show(id);
		cuenta.replace(cuentaData);
		return this.cuentaR.save(cuenta);
	}
	
	
	public void delete(Integer id) throws Exception
	{		
		Cuenta cuenta = this.show(id);
		this.cuentaR.delete(cuenta);
	}
}
