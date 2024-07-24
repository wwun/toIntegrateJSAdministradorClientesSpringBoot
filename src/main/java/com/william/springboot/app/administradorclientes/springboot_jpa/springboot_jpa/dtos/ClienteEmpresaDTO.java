package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteEmpresaDTO {

    @JsonProperty("id")
    private Long idCliente;

    @JsonProperty("nombre")
    @NotBlank(message = "{nombre.NotBlank}")
    @Size(min=1, max=200, message = "{nombre.Size}")
    private String nombreCliente;

    @JsonProperty("email")
    //@NotBlank
    //(message = "${email.NotBlank}")
    @Email(message = "{email.Email}")
    private String emailCliente;

    @JsonProperty("telefono")
    @NotBlank(message = "{telefono.NotBlank}")
    @Size(min=1, max=10, message = "{telefono.Size}")
    private String telefonoCliente;

    @JsonProperty("empresa")
    @NotBlank(message = "{empresa.NotBlank}")
    @Size(min=1, max=200, message = "{empresa.Size}")
    private String nombreEmpresa;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    
}
