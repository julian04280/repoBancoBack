package com.banco.banco.controller.modelResponse;

public class ApiResponseDefault {


    private String codStatus;
    private String status;
    private String description;

    public ApiResponseDefault() {}

    public ApiResponseDefault(String codStatus, String status, String description) {
        this.codStatus = codStatus;
        this.status = status;
        this.description = description;
    }

    public String getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
