package com.gym.gym_ver2.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @OneToMany(fetch =FetchType.LAZY, mappedBy = "idRol" )
    private List<Usuario> usuarios;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Rol() {
    }

    public Rol(Integer idRol, String nombreRol, List<Usuario> usuarios) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.usuarios = usuarios;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}