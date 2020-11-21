package com.banco.banco.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bancos")
public class Banco implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banco_identificacion")
	private Integer bancoIdentificacion;

	@Column(name = "banco_nombre", length = 128, nullable = false)
	private String bancoNombre;


	public Integer getBancoIdentificacion() {
		return bancoIdentificacion;
	}

	public void setBancoIdentificacion(Integer bancoIdentificacion) {
		this.bancoIdentificacion = bancoIdentificacion;
	}

	public String getBancoNombre() {
		return bancoNombre;
	}

	public void setBancoNombre(String bancoNombre) {
		this.bancoNombre = bancoNombre;
	}


	private static final long serialVersionUID = 1L;
}
