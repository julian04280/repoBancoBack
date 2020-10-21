package com.banco.banco.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	private String identificacion;

	@Column(name = "nombre", length = 128, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 128, nullable = false)
	private String apellido;

	@Column(name = "sexo", nullable = false)
	private Integer sexo;

	@Column(name = "fechaNacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "numeroCelular")
	private Integer numeroCelular;

	@Column(name = "clave", length = 128, nullable = false)
	private String clave;

	@Column(name = "fechaRegistro")
	private LocalDate fechaRegistro;

	// Relacion muchos a uno
	@OneToOne
	@JoinColumn(name = "bancoIdentificacion")
	private Banco banco;

	// Relacion muchos a muchos
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "clientesRoles", joinColumns = @JoinColumn(name = "identificacion"), inverseJoinColumns = @JoinColumn(name = "rolIdentificacion"))
	private List<Rol> roles;

	// Relacion uno a muchos
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Transaction> transaction;
	
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

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"identificacion='" + identificacion + '\'' +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", sexo=" + sexo +
				", fechaNacimiento=" + fechaNacimiento +
				", numeroCelular=" + numeroCelular +
				", clave='" + clave + '\'' +
				", fechaRegistro=" + fechaRegistro +
				", banco=" + banco +
				", roles=" + roles +
				", transaction=" + transaction +
				'}';
	}
}
