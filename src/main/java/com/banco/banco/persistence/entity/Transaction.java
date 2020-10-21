package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "transaccion")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionIdentificacion;

	@Column(name = "codPasarela", length = 128, nullable = false)
	private String codPasarela;

	@Column(name = "referencia", length = 128, nullable = false)
	private String referencia;

	@Column(name = "urlRetorno", nullable = false)
	private String urlRetorno;

	// Relacion uno a uno
	@OneToOne
	@JoinColumn(name = "codCuenta")
	private Cuenta cuenta;

	// Relacion uno a uno
	@OneToOne
	@JoinColumn(name = "comercioIdentificacion")
	private Comercio comercio;

	public Integer getTransactionIdentificacion() {
		return transactionIdentificacion;
	}

	public void setTransactionIdentificacion(Integer transactionIdentificacion) {
		this.transactionIdentificacion = transactionIdentificacion;
	}

	public String getCodPasarela() {
		return codPasarela;
	}

	public void setCodPasarela(String codPasarela) {
		this.codPasarela = codPasarela;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getUrlRetorno() {
		return urlRetorno;
	}

	public void setUrlRetorno(String urlRetorno) {
		this.urlRetorno = urlRetorno;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"transactionIdentificacion=" + transactionIdentificacion +
				", codPasarela='" + codPasarela + '\'' +
				", referencia='" + referencia + '\'' +
				", urlRetorno='" + urlRetorno + '\'' +
				", cuenta=" + cuenta +
				", comercio=" + comercio +
				'}';
	}
}
