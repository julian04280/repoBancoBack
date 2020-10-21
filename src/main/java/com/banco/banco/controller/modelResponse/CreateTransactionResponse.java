package com.banco.banco.controller.modelResponse;

public class CreateTransactionResponse {


    private String codigoEstado;
    private String estado;
    private String descripcionEstado;
    private String urlRedirigir;
    private String lifetimeSecs;
    private String idTransaccion;

    public CreateTransactionResponse() {}

    public CreateTransactionResponse(String codigoEstado, String estado, String descripcionEstado, String urlRedirigir, String lifetimeSecs, String idTransaccion) {
        this.codigoEstado = codigoEstado;
        this.estado = estado;
        this.descripcionEstado = descripcionEstado;
        this.urlRedirigir = urlRedirigir;
        this.lifetimeSecs = lifetimeSecs;
        this.idTransaccion = idTransaccion;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getUrlRedirigir() {
        return urlRedirigir;
    }

    public void setUrlRedirigir(String urlRedirigir) {
        this.urlRedirigir = urlRedirigir;
    }

    public String getLifetimeSecs() {
        return lifetimeSecs;
    }

    public void setLifetimeSecs(String lifetimeSecs) {
        this.lifetimeSecs = lifetimeSecs;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
}
