package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMERCIO")
public class Comercio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comercio_identificacion;

	@Column(name = "refComercio", length = 128, nullable = false)
	private String refComercio;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "tipo", nullable = false)
	private Double tipo;

	// Relacion uno a uno
	@OneToOne
	@JoinColumn(name = "codCuenta")
	private Cuenta cuenta;

	public Integer getComercio_identificacion() {
		return comercio_identificacion;
	}

	public void setComercio_identificacion(Integer comercio_identificacion) {
		this.comercio_identificacion = comercio_identificacion;
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

	public Double getTipo() {
		return tipo;
	}

	public void setTipo(Double tipo) {
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
				"comercio_identificacion=" + comercio_identificacion +
				", refComercio='" + refComercio + '\'' +
				", descripcion='" + descripcion + '\'' +
				", valor=" + valor +
				", tipo=" + tipo +
				", cuenta=" + cuenta +
				'}';
	}
}
