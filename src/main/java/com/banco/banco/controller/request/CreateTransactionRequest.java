package com.banco.banco.controller.request;

public class CreateTransactionRequest {

    private String codPasarela;
    private String referencia;
    private String urlRetorno;
    private OriginCommerceRequest origenComercio;
    private TradeCommerceRequest destinoComercio;

    public CreateTransactionRequest(String codPasarela, String referencia, String urlRetorno, OriginCommerceRequest origenComercio, TradeCommerceRequest destinoComercio) {
        this.codPasarela = codPasarela;
        this.referencia = referencia;
        this.urlRetorno = urlRetorno;
        this.origenComercio = origenComercio;
        this.destinoComercio = destinoComercio;
    }

    public String getCodPasarela() {
        return codPasarela;
    }

    public void setCodPasarela(String codPasarela) {
        this.codPasarela = codPasarela;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUrlRetorno() {
        return urlRetorno;
    }

    public void setUrlRetorno(String urlRetorno) {
        this.urlRetorno = urlRetorno;
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
}
