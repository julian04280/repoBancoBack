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
	private Integer rolIdentificacion;
	@Column(name = "rolNombre", length = 128)
	private String rolNombre;

	// Relacion muchos a muchos
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Cliente> clientes;

	public Integer getRolIdentificacion() {
		return rolIdentificacion;
	}

	public void setRolIdentificacion(Integer rolIdentificacion) {
		this.rolIdentificacion = rolIdentificacion;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Rol{" +
				"rolIdentificacion=" + rolIdentificacion +
				", rolNombre='" + rolNombre + '\'' +
				", clientes=" + clientes +
				'}';
	}
}
