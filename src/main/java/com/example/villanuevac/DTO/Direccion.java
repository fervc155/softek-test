package com.example.villanuevac.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


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
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Usuario usuario;
   
	
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

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	public Direccion replace(Direccion data)
	{
		this.estado = data.getestado();
		this.codigoPostal = data.getcodigoPostal();
		return this;
	}
}


