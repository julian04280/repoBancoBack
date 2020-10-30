package com.banco.banco.controller.modelRequest;

public class OriginCommerceRequest {

    private String nombreComprador;
    private String numeroCelular;
    private String apellidoComprador;
    private String numeroCedula;
    private String valor;

    public OriginCommerceRequest(String nombreComprador, String numeroCelular, String apellidoComprador, String numeroCedula, String valor) {
        this.nombreComprador = nombreComprador;
        this.numeroCelular = numeroCelular;
        this.apellidoComprador = apellidoComprador;
        this.numeroCedula = numeroCedula;
        this.valor = valor;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getApellidoComprador() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
