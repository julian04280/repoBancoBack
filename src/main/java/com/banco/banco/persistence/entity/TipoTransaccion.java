package com.banco.banco.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipoTransaccion")
public class TipoTransaccion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoTransaccion;
	@Column(name = "descripcion", length = 128)
	private String descripcion;

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
}
