package com.example.villanuevac.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="usuarios")
public class Usuario {

	@Id 	@GeneratedValue
	private int id;
	
	@NotBlank
	@Column(name = "nombre", length=50)
	private String nombre;
	
	@NotBlank
	@Column(name = "apellidoPaterno", length=50)
	private String apellidoPaterno;
	
	@NotBlank
	@Column(name = "apellidoMaterno", length=50)
	private String apellidoMaterno;
	
	@NotNull @JsonFormat(pattern="dd/mm/yyyy")
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "usuario_id")
    private List<Cuenta> cuentas = new ArrayList<>();
   
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "usuario_id")
    private List<Direccion> direcciones = new ArrayList<>();
   
    public int getId()
	{
		return this.id;
	}
	
	public String getnombre()
	{
		return this.nombre;
	}
	
	public String getapellidoPaterno()
	{
		return this.apellidoPaterno;
	}
	
	public String getapellidoMaterno()
	{
		return this.apellidoMaterno;
	}

	public Date getfechaNacimiento()
	{
		return this.fechaNacimiento;
	}
	
	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}
	public List<Direccion> getDirecciones() {
		return this.direcciones;
	}
		
	public Usuario replace(Usuario data)
	{
		this.nombre = data.getnombre();
		this.apellidoPaterno = data.getapellidoPaterno();
		this.apellidoMaterno = data.getapellidoMaterno();
		this.fechaNacimiento = data.getfechaNacimiento();
		return this;
	}
	
}
