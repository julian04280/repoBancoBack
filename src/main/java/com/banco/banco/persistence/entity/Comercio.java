package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMERCIO")
public class Comercio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comercioIdentificacion;

	@Column(name = "refComercio", length = 128, nullable = false)
	private String refComercio;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	// Relacion uno a uno
	@OneToOne
	@JoinColumn(name = "codCuenta")
	private Cuenta cuenta;

	public Integer getComercioIdentificacion() {
		return comercioIdentificacion;
	}

	public void setComercioIdentificacion(Integer comercioIdentificacion) {
		this.comercioIdentificacion = comercioIdentificacion;
	}

	public String getRefComercio() {
		return refComercio;
	}

	public void setRefComercio(String refComercio) {
		this.refComercio = refComercio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Comercio{" +
				"comercioIdentificacion=" + comercioIdentificacion +
				", refComercio='" + refComercio + '\'' +
				", descripcion='" + descripcion + '\'' +
				", valor=" + valor +
				", tipo=" + tipo +
				", cuenta=" + cuenta +
				'}';
	}
}
