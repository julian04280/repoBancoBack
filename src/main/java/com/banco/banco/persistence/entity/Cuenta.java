package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {

	@Id
	@Column(name = "cuenta_cod", length = 128)
	private String codCuenta;

	@Column(name = "cuenta_tipo", length = 128, nullable = false)
	private String tipo;

	@Column(name = "cuenta_descripcion", length = 128, nullable = false)
	private String descripcion;


	@Column(name = "cliente_identificacion")
	private String clienteId;

	// Relacion muchos a uno
	@OneToOne
	@JoinColumn(name = "banco_identificacion")
	private Banco banco;

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

	

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	

	@Override
	public String toString() {
		return "Cuenta [codCuenta=" + codCuenta + ", tipo=" + tipo + ", descripcion=" + descripcion + ", clienteId="
				+ clienteId + ", banco=" + banco + "]";
	}






	private static final long serialVersionUID = 1L;
}
