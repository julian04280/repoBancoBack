package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CUENTA")
public class Cuenta implements Serializable {

	@Id
	private String codCuenta;

	@Column(name = "tipo", length = 128, nullable = false)
	private String tipo;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	// Relacion uno a muchos
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Cliente> cliente;

	// Relacion muchos a uno
	@OneToOne
	@JoinColumn(name = "bancoIdentificacion")
	private Banco banco;

	public Cuenta() {
	}

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

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "Cuenta{" +
				"codCuenta='" + codCuenta + '\'' +
				", tipo='" + tipo + '\'' +
				", descripcion='" + descripcion + '\'' +
				", cliente=" + cliente +
				", banco=" + banco +
				'}';
	}
}
