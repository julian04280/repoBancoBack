package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "transacciones")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaccion_identificacion")
	private Integer transactionIdentificacion;

	@Column(name = "transaccion_fecha")
	private LocalDate fecha;

	@Column(name = "transaccion_monto", precision = 8, scale = 2, nullable = false)
	private Double monto;

	@Column(name = "transaccion_descripcion", length = 128, nullable = false)
	private String descripcion;

	@Column(name = "transaccion_estado", length = 128, nullable = false)
	private String estado;

	@Column(name = "urlRetorno", length = 128, nullable = false)
	private String urlRetorno;

	@Column(name = "cuenta_recaudador", length = 128, nullable = false)
	private String cuentaRecaudador;

	// Relacion uno a uno
	@Column(name = "id_cuenta", length = 128)
	private String idCuenta;

	@Column(name = "id_tipotransaccion")
	private Integer tipoTransaccion;

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

	public String getUrlRetorno() {
		return urlRetorno;
	}

	public void setUrlRetorno(String urlRetorno) {
		this.urlRetorno = urlRetorno;
	}

	public String getCuentaRecaudador() {
		return cuentaRecaudador;
	}

	public void setCuentaRecaudador(String cuentaRecaudador) {
		this.cuentaRecaudador = cuentaRecaudador;
	}

	public Integer getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(Integer tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}

	@Override
	public String toString() {
		return "Transaction [transactionIdentificacion=" + transactionIdentificacion + ", fecha=" + fecha + ", monto="
				+ monto + ", descripcion=" + descripcion + ", estado=" + estado + ", urlRetorno=" + urlRetorno
				+ ", cuentaRecaudador=" + cuentaRecaudador + ", idCuenta=" + idCuenta + ", tipoTransaccion="
				+ tipoTransaccion + "]";
	}

}
