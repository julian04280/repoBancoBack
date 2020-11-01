package com.banco.banco.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {


	@Id
	@Column(name = "cliente_identificacion", length = 128)
	private String identificacion;
    
	@Column(name = "cliente_nombre", length = 128, nullable = false)
	private String nombre;

	@Column(name = "cliente_apellido", length = 128, nullable = false)
	private String apellido;

	@Column(name = "cliente_sexo", nullable = false)
	private Integer sexo;

	@Column(name = "cliente_fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "cliente_numerocelular")
	private Integer numeroCelular;

	@Column(name = "cliente_clave", length = 128, nullable = false)
	private String clave;

	@Column(name = "cliente_fecha_registro")
	private LocalDate fechaRegistro;

	// Relacion muchos a uno
	@ManyToOne
	@JoinColumn(name = "banco_identificacion", referencedColumnName = "banco_identificacion", nullable = false)
	private Banco banco;
	
	// Relacion muchos a muchos
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cliente_roles", joinColumns = @JoinColumn(name = "cliente_identificacion"), inverseJoinColumns = @JoinColumn(name = "rol_identificacion"))
	private List<Rol> roles;


	@PrePersist
	@PreUpdate
	private void prePersist() {
		this.fechaRegistro = LocalDate.now();
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Integer getSexo() {
		return sexo;
	}


	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Integer getNumeroCelular() {
		return numeroCelular;
	}


	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public List<Rol> getRoles() {
		return roles;
	}


	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;
}
