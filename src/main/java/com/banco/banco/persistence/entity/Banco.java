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
	private Integer bancoIdentificacion;

	@Column(name = "bancoNombre", length = 128, nullable = false)
	private String bancoNombre;

	@Column(name = "bancoLlave", length = 128, nullable = false)
	private String bancoLlave;

	@Column(name = "bancoLogo",  length = 128 )
	private String bancoLogo;

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

	public String getBancoLlave() {
		return bancoLlave;
	}

	public void setBancoLlave(String bancoLlave) {
		this.bancoLlave = bancoLlave;
	}

	public String getBancoLogo() {
		return bancoLogo;
	}

	public void setBancoLogo(String bancoLogo) {
		this.bancoLogo = bancoLogo;
	}

	@Override
	public String toString() {
		return "Banco{" +
				"bancoIdentificacion=" + bancoIdentificacion +
				", bancoNombre='" + bancoNombre + '\'' +
				", bancoLlave='" + bancoLlave + '\'' +
				", bancoLogo='" + bancoLogo + '\'' +
				'}';
	}
}
