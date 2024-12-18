package com.gym.gym_ver2.domain.model.pojos;

import jakarta.persistence.Column;
import lombok.*;

import java.sql.Date;


public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String emailUsuario;
    private String nombreUsuario;


    public UsuarioDTO( Integer idUsuario, String nombre, String emailUsuario, String nombreUsuario) {

        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.emailUsuario = emailUsuario;
        this.nombreUsuario = nombreUsuario;

    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}

