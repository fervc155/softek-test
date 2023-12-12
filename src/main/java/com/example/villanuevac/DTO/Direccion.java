package com.example.villanuevac.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name ="direcciones")
public class Direccion {

	@Id @GeneratedValue
	private int id;
	
	@Size(min = 6, max = 6)
	@Column(name= "codigoPostal", length=6)
	private String codigoPostal;

	@NotBlank
	@Column(name= "estado", length=50)
	private String estado;
	public int getId()
	{
		return this.id;
	}
	
	public String getcodigoPostal()
	{
		return this.codigoPostal;
	}
	
	public String getestado()
	{
		return this.estado;
	}

	public Direccion replace(Direccion data)
	{
		this.estado = data.getestado();
		this.codigoPostal = data.getcodigoPostal();
		return this;
	}
}


