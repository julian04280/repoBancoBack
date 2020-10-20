package com.banco.banco.controller.request;

public class OriginCommerceRequest {

    private String refComercio;
    private String descripcion;
    private String valor;

    private String numeroDocumento;
    private String tipoDocumento;
    private String nombreComprador;
    private String numeroCelular;

    public OriginCommerceRequest(String refComercio, String descripcion, String valor, String numeroDocumento, String tipoDocumento, String nombreComprador, String numeroCelular) {
        this.refComercio = refComercio;
        this.descripcion = descripcion;
        this.valor = valor;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombreComprador = nombreComprador;
        this.numeroCelular = numeroCelular;
    }

    public String getRefComercio() {
        return refComercio;
    }

    public void setRefComercio(String refComercio) {
        this.refComercio = refComercio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
}
