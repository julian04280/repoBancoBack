package com.banco.banco.persistence.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "log_transacciones")
public class LogTransaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_log_transaccion")
	private Integer idLogTransaccion;
	
	@Column(name = "transaccion_fecha")
	private LocalDate fechaTransaccion;
	
	// Relacion uno a uno
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transaccion_identificacion")
	private Transaction transaction;

	public Integer getIdLogTransaccion() {
		return idLogTransaccion;
	}

	public void setIdLogTransaccion(Integer idLogTransaccion) {
		this.idLogTransaccion = idLogTransaccion;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "LogTransaccion [idLogTransaccion=" + idLogTransaccion + ", fechaTransaccion=" + fechaTransaccion
				+ ", transaction=" + transaction + "]";
	}
	
	private static final long serialVersionUID = 1L;

}
