package com.banco.banco.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tipotransaccion")
public class TipoTransaccion implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipotransaccion")
	private Integer idTipoTransaccion;
	
	@Column(name = "tipotransaccion_descripcion", length = 128)
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
	
	private static final long serialVersionUID = 1L;
}
