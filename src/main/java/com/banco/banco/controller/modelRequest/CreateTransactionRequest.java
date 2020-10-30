package com.banco.banco.controller.modelRequest;


import java.time.LocalDate;

public class CreateTransactionRequest {

    private LocalDate fecha;
    private Double monto;
    private String descripcion;
    private String estado;
    private String cuentaRecaudador;
    private String cuenta;
    private String urlRetorno;

    private OriginCommerceRequest origenComercio;
    private TradeCommerceRequest destinoComercio;

    public CreateTransactionRequest(LocalDate fecha, Double monto, String descripcion, String estado, String cuentaRecaudador, String cuenta, String urlRetorno, OriginCommerceRequest origenComercio, TradeCommerceRequest destinoComercio) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cuentaRecaudador = cuentaRecaudador;
        this.cuenta = cuenta;
        this.urlRetorno = urlRetorno;
        this.origenComercio = origenComercio;
        this.destinoComercio = destinoComercio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCuentaRecaudador() {
        return cuentaRecaudador;
    }

    public void setCuentaRecaudador(String cuentaRecaudador) {
        this.cuentaRecaudador = cuentaRecaudador;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public OriginCommerceRequest getOrigenComercio() {
        return origenComercio;
    }

    public void setOrigenComercio(OriginCommerceRequest origenComercio) {
        this.origenComercio = origenComercio;
    }

    public TradeCommerceRequest getDestinoComercio() {
        return destinoComercio;
    }

    public void setDestinoComercio(TradeCommerceRequest destinoComercio) {
        this.destinoComercio = destinoComercio;
    }

    public String getUrlRetorno() {
        return urlRetorno;
    }

    public void setUrlRetorno(String urlRetorno) {
        this.urlRetorno = urlRetorno;
    }
}
