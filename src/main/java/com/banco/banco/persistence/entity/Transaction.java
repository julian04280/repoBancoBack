package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "transaccion")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionIdentificacion;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "monto", nullable = false)
	private Double monto;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "cuentaRecaudador", nullable = false)
	private String cuentaRecaudador;

	// Relacion uno a uno
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "codCuenta")
	private Cuenta cuenta;

	// Relacion uno a uno
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "tipoTransaccion")
	private TipoTransaccion tipoTransaccion;

	public Transaction() {
	}

	public Integer getTransactionIdentificacion() {
		return transactionIdentificacion;
	}

	public void setTransactionIdentificacion(Integer transactionIdentificacion) {
		this.transactionIdentificacion = transactionIdentificacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCuentaRecaudador() {
		return cuentaRecaudador;
	}

	public void setCuentaRecaudador(String cuentaRecaudador) {
		this.cuentaRecaudador = cuentaRecaudador;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"transactionIdentificacion=" + transactionIdentificacion +
				", fecha=" + fecha +
				", monto=" + monto +
				", descripcion='" + descripcion + '\'' +
				", estado='" + estado + '\'' +
				", cuentaRecaudador='" + cuentaRecaudador + '\'' +
				", cuenta=" + cuenta +
				", tipoTransaccion=" + tipoTransaccion +
				'}';
	}
}
