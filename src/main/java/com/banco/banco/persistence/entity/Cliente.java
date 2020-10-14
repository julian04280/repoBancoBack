package com.banco.banco.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	private String per_identificacion;

	@Column(name = "per_nombre", length = 128, nullable = false)
	private String per_nombre;

	@Column(name = "per_apellido", length = 128, nullable = false)
	private String per_apellido;

	@Column(name = "per_sexo", nullable = false)
	private Integer per_sexo;

	@Column(name = "per_fecha_nacimiento")
	private LocalDate per_fecha_nacimiento;

	@Column(name = "per_numero_celular")
	private Integer per_numero_celular;

	@Column(name = "per_clave", length = 128, nullable = false)
	private String per_clave;

	@Column(name = "fecha_registro")
	private LocalDate fecha_registro;

	// Relacion muchos a uno
	@ManyToOne
	@JoinColumn(name = "banco_identificacion", referencedColumnName = "banco_identificacion", nullable = false)
	private Banco banco;

	// Relacion muchos a muchos
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "clientes_roles", joinColumns = @JoinColumn(name = "per_identificacion"), inverseJoinColumns = @JoinColumn(name = "rol_identificacion"))
	private List<Rol> roles;
	
	
	@PrePersist
	@PreUpdate
	private void prePersist() {
		 this.fecha_registro = LocalDate.now();
	}
	

	public String getPer_identificacion() {
		return per_identificacion;
	}

	public void setPer_identificacion(String per_identificacion) {
		this.per_identificacion = per_identificacion;
	}

	public String getPer_nombre() {
		return per_nombre;
	}

	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}

	public String getPer_apellido() {
		return per_apellido;
	}

	public void setPer_apellido(String per_apellido) {
		this.per_apellido = per_apellido;
	}

	public Integer getPer_sexo() {
		return per_sexo;
	}

	public void setPer_sexo(Integer per_sexo) {
		this.per_sexo = per_sexo;
	}

	public LocalDate getPer_fecha_nacimiento() {
		return per_fecha_nacimiento;
	}

	public void setPer_fecha_nacimiento(LocalDate per_fecha_nacimiento) {
		this.per_fecha_nacimiento = per_fecha_nacimiento;
	}

	public Integer getPer_numero_celular() {
		return per_numero_celular;
	}

	public void setPer_numero_celular(Integer per_numero_celular) {
		this.per_numero_celular = per_numero_celular;
	}

	public String getPer_clave() {
		return per_clave;
	}

	public void setPer_clave(String per_clave) {
		this.per_clave = per_clave;
	}

	public LocalDate getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDate fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Cliente [per_identificacion=" + per_identificacion + ", per_nombre=" + per_nombre + ", per_apellido="
				+ per_apellido + ", per_sexo=" + per_sexo + ", per_fecha_nacimiento=" + per_fecha_nacimiento
			     + ", per_numero_celular=" + per_numero_celular + ", per_clave=" + per_clave
				+ ", fecha_registro=" + fecha_registro + ", banco=" + banco + "]";
	}
}
