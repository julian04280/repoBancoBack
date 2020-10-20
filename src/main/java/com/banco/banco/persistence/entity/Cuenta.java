package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUENTA")
public class Cuenta implements Serializable {

	@Id
	private String codCuenta;

	@Column(name = "tipo", length = 128, nullable = false)
	private String tipo;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "idTitularCuenta", nullable = false)
	private String idTitularCuenta;

	@Column(name = "nombreTitularCuenta", nullable = false)
	private String nombreTitularCuenta;

	public String getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdTitularCuenta() {
		return idTitularCuenta;
	}

	public void setIdTitularCuenta(String idTitularCuenta) {
		this.idTitularCuenta = idTitularCuenta;
	}

	public String getNombreTitularCuenta() {
		return nombreTitularCuenta;
	}

	public void setNombreTitularCuenta(String nombreTitularCuenta) {
		this.nombreTitularCuenta = nombreTitularCuenta;
	}

	@Override
	public String toString() {
		return "Cuenta{" +
				"codCuenta='" + codCuenta + '\'' +
				", tipo='" + tipo + '\'' +
				", descripcion='" + descripcion + '\'' +
				", idTitularCuenta='" + idTitularCuenta + '\'' +
				", nombreTitularCuenta='" + nombreTitularCuenta + '\'' +
				'}';
	}
}
