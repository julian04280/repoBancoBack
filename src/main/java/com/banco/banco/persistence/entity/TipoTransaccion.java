package com.banco.banco.persistence.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "tipotransaccion")
public class TipoTransaccion implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipotransaccion")
	private Integer idTipoTransaccion;
	
	@Column(name = "tipotransaccion_descripcion", length = 128)
	private String descripcion;
	
	// Relacion uno a muchos
	@OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL, mappedBy = "tipoTransaccion")
	@JsonIgnore
	private List<Transaction> transacciones;

	public TipoTransaccion() {
	}

	public Integer getIdTipoTransaccion() {
		return idTipoTransaccion;
	}

	public void setIdTipoTransaccion(Integer idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoTransaccion{" +
				"idTipoTransaccion=" + idTipoTransaccion +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
	
	private static final long serialVersionUID = 1L;
}
