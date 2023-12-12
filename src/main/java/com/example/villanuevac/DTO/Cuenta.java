package com.example.villanuevac.DTO;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name ="cuentas")
 public class Cuenta {

	@Id 
	@GeneratedValue
    private int id;
	
	@Column(name= "numeroCuenta", precision=10)
	private int numeroCuenta;

	@Min(value=0)
	@Column(name= "ingresos", precision=10, scale=4)
	private float ingresos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Usuario usuario;
   
	public int getId()
	{
		return this.id;
	}
	
	public int getnumeroCuenta()
	{
		return this.numeroCuenta;
	}
	
	public float getIngresos()
	{
		return this.ingresos;
	}
	
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	public Usuario getusuario()
	{
		return this.usuario;
	}
	
	public int setnumeroCuenta(int value) throws Exception
	{
		String val = String.valueOf(value);
		if(val.length()!=10) {
			throw new Exception("Numero de cuenta largo invalido");
		}
		return this.numeroCuenta = value;
	}
	
	public Cuenta replace(Cuenta cuentaData)
	{
		this.numeroCuenta = cuentaData.getnumeroCuenta();
		this.ingresos = cuentaData.getIngresos();
		return this;
	}
	
}


