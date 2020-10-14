package com.banco.banco.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rol_identificacion;
	@Column(name = "rol_nombre", length = 128)
	private String rol_nombre;

	// Relacion muchos a muchos
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Cliente> clientes;

	public Integer getRol_identificacion() {
		return rol_identificacion;
	}

	public void setRol_identificacion(Integer rol_identificacion) {
		this.rol_identificacion = rol_identificacion;
	}

	public String getRol_nombre() {
		return rol_nombre;
	}

	public void setRol_nombre(String rol_nombre) {
		this.rol_nombre = rol_nombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Rol [rol_identificacion=" + rol_identificacion + ", rol_nombre=" + rol_nombre
				+ ", getRol_identificacion()=" + getRol_identificacion() + ", getRol_nombre()=" + getRol_nombre()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
