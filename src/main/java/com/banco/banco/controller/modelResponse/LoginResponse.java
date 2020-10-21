package com.banco.banco.controller.modelResponse;

public class LoginResponse {

	private Integer rol_identificacion;
	
	private String rol_nombre;
	
	private String menssage;
	
	private String per_identificacion;

	private String per_nombre;

	private String per_apellido;
	
	private Integer banco_identificacion;

	private String banco_nombre;
	
	private String banco_llave;

	private String banco_logo;

	public LoginResponse(Integer rol_identificacion, String rol_nombre, String menssage, String per_identificacion,
			String per_nombre, String per_apellido, Integer banco_identificacion, String banco_nombre,
			String banco_llave, String banco_logo) {
		super();
		this.rol_identificacion = rol_identificacion;
		this.rol_nombre = rol_nombre;
		this.menssage = menssage;
		this.per_identificacion = per_identificacion;
		this.per_nombre = per_nombre;
		this.per_apellido = per_apellido;
		this.banco_identificacion = banco_identificacion;
		this.banco_nombre = banco_nombre;
		this.banco_llave = banco_llave;
		this.banco_logo = banco_logo;
	}

	public Integer getRol_identificacion() {
		return rol_identificacion;
	}

	public void setRol_identificacion(Integer rol_identificacion) {
		this.rol_identificacion = rol_identificacion;
	}

	public String getRol_nombre() {
		return rol_nombre;
	}

	public void setRol_nombre(String rol_nombre) {
		this.rol_nombre = rol_nombre;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
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

	public Integer getBanco_identificacion() {
		return banco_identificacion;
	}

	public void setBanco_identificacion(Integer banco_identificacion) {
		this.banco_identificacion = banco_identificacion;
	}

	public String getBanco_nombre() {
		return banco_nombre;
	}

	public void setBanco_nombre(String banco_nombre) {
		this.banco_nombre = banco_nombre;
	}

	public String getBanco_llave() {
		return banco_llave;
	}

	public void setBanco_llave(String banco_llave) {
		this.banco_llave = banco_llave;
	}

	public String getBanco_logo() {
		return banco_logo;
	}

	public void setBanco_logo(String banco_logo) {
		this.banco_logo = banco_logo;
	}
	
	public LoginResponse() {
		
	}
	
}
