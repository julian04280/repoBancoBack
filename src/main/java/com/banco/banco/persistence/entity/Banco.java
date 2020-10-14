package com.banco.banco.persistence.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bancos")
public class Banco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer banco_identificacion;

	@Column(name = "banco_nombre", length = 128, nullable = false)
	private String banco_nombre;

	@Column(name = "banco_llave", length = 128, nullable = false)
	private String banco_llave;

	@Column(name = "banco_logo",  length = 128 )
	private String banco_logo;

	public Integer getBanco_identificacion() {
		return banco_identificacion;
	}

	public void setBanco_identificacion(Integer banco_identificacion) {
		this.banco_identificacion = banco_identificacion;
	}

	public String getBanco_nombre() {
		return banco_nombre;
	}

	public void setBanco_nombre(String banco_nombre) {
		this.banco_nombre = banco_nombre;
	}

	public String getBanco_llave() {
		return banco_llave;
	}

	public void setBanco_llave(String banco_llave) {
		this.banco_llave = banco_llave;
	}

	
	public String getBanco_logo() {
		return banco_logo;
	}

	public void setBanco_logo(String banco_logo) {
		this.banco_logo = banco_logo;
	}


	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Banco [banco_identificacion=" + banco_identificacion + ", banco_nombre=" + banco_nombre
				+ ", banco_llave=" + banco_llave + ", banco_logo=" + banco_logo + "]";
	}
}
