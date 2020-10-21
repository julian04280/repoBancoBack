package com.banco.banco.controller.modelResponse;

public class LoginResponse {

	private Integer rolIdentificacion;
	
	private String rolNombre;
	
	private String menssage;
	
	private String identificacion;

	private String nombre;

	private String apellido;
	
	private Integer bancoIdentificacion;

	private String bancoNombre;
	
	private String bancoLlave;

	private String bancoLogo;

	public LoginResponse() {}

	public LoginResponse(Integer rolIdentificacion, String rolNombre, String menssage, String identificacion, String nombre, String apellido, Integer bancoIdentificacion, String bancoNombre, String bancoLlave, String bancoLogo) {
		this.rolIdentificacion = rolIdentificacion;
		this.rolNombre = rolNombre;
		this.menssage = menssage;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.bancoIdentificacion = bancoIdentificacion;
		this.bancoNombre = bancoNombre;
		this.bancoLlave = bancoLlave;
		this.bancoLogo = bancoLogo;
	}

	public Integer getRolIdentificacion() {
		return rolIdentificacion;
	}

	public void setRolIdentificacion(Integer rolIdentificacion) {
		this.rolIdentificacion = rolIdentificacion;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getBancoIdentificacion() {
		return bancoIdentificacion;
	}

	public void setBancoIdentificacion(Integer bancoIdentificacion) {
		this.bancoIdentificacion = bancoIdentificacion;
	}

	public String getBancoNombre() {
		return bancoNombre;
	}

	public void setBancoNombre(String bancoNombre) {
		this.bancoNombre = bancoNombre;
	}

	public String getBancoLlave() {
		return bancoLlave;
	}

	public void setBancoLlave(String bancoLlave) {
		this.bancoLlave = bancoLlave;
	}

	public String getBancoLogo() {
		return bancoLogo;
	}

	public void setBancoLogo(String bancoLogo) {
		this.bancoLogo = bancoLogo;
	}
}
