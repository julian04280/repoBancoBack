package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transaction_identificacion;

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
	@JoinColumn(name = "comercio_identificacion")
	private Comercio comercio;

	public Integer getTransaction_identificacion() {
		return transaction_identificacion;
	}

	public void setTransaction_identificacion(Integer transaction_identificacion) {
		this.transaction_identificacion = transaction_identificacion;
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
				"transaction_identificacion=" + transaction_identificacion +
				", codPasarela='" + codPasarela + '\'' +
				", referencia='" + referencia + '\'' +
				", urlRetorno='" + urlRetorno + '\'' +
				", cuenta=" + cuenta +
				", comercio=" + comercio +
				'}';
	}
}
