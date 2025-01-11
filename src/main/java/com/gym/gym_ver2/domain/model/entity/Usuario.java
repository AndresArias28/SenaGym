package com.gym.gym_ver2.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email_usuario"),
        @UniqueConstraint(columnNames = "contrasena_usuario")
})
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    private Rol idRol;

    @Column(name="nombre_usuario")
    private String nombreUsuario;

    @Column(name="apellido_usuario")
    private String apellidoUsuario;

    @Column(name="cedula_usuario")
    private String cedulaUsuario;

    @Column(name="fecha_nacimineto")
    private Date fechaNacimiento;

    @Column(name = "contrasena_usuario")
    private String contrasenaUsuario;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @Column(name = "estatura_usuario")
    private Double estaturaUsuario;

    @Column(name = "peso_usuario")
    private Double pesoUsuario;

    @Column(name = "puntos_acumulados_usuario")
    private Integer puntosUsuario;

    @Column(name = "numero_ficha_usuario")
    private Integer numeroFicha;

    @Column(name = "recompensa_horas_usuario")
    private Integer horasRecompensas;

    @Column(name = "nivel_actual_usuario")
    private Integer nivelActualUsuario;

    @Column(name = "codigoqr_admin")
    private String qrAdmin;

//    public Usuario() {
//    }
//
//    public Usuario(
//            String nombreUsuario,
//            String apellidoUsuario,
//            String cedulaUsuario,
//            Date fechaNacimiento,
//            String contrasenaUsuario,
//            String emailUsuario,
//            Double estaturaUsuario,
//            Double pesoUsuario,
//            Integer puntosUsuario,
//            Integer numeroFicha,
//            Integer horasRecompensas,
//            Integer nivelActualUsuario,
//            String qrAdmin
//    ) {
//
//        Rol rolPorDefecto = new Rol();
//        rolPorDefecto.setIdRol(2);
//
//        this.idRol = rolPorDefecto;
//        this.nombreUsuario = nombreUsuario;
//        this.apellidoUsuario = apellidoUsuario;
//        this.cedulaUsuario = cedulaUsuario;
//        this.fechaNacimiento = fechaNacimiento;
//        this.contrasenaUsuario = contrasenaUsuario;
//        this.emailUsuario = emailUsuario;
//        this.estaturaUsuario = estaturaUsuario;
//        this.pesoUsuario = pesoUsuario;
//        this.puntosUsuario = puntosUsuario;
//        this.numeroFicha = numeroFicha;
//        this.horasRecompensas = horasRecompensas;
//        this.nivelActualUsuario = nivelActualUsuario;
//        this.qrAdmin = qrAdmin;
//    }
//
//    public Integer getIdUsuario() {
//        return idUsuario;
//    }
//
//    public void setIdUsuario(Integer idUsuario) {
//        this.idUsuario = idUsuario;
//    }
//
//    public Rol getIdRol() {
//        return idRol;
//    }
//
//    public void setIdRol(Rol idRol) {
//        this.idRol = idRol;
//    }
//
//    public String getNombreUsuario() {
//        return nombreUsuario;
//    }
//
//    public void setNombreUsuario(String nombreUsuario) {
//        this.nombreUsuario = nombreUsuario;
//    }
//
//    public String getApellidoUsuario() {
//        return apellidoUsuario;
//    }
//
//    public void setApellidoUsuario(String apellidoUsuario) {
//        this.apellidoUsuario = apellidoUsuario;
//    }
//
//    public String getCedulaUsuario() {
//        return cedulaUsuario;
//    }
//
//    public void setCedulaUsuario(String cedulaUsuario) {
//        this.cedulaUsuario = cedulaUsuario;
//    }
//
//    public Date getFechaNacimiento() {
//        return fechaNacimiento;
//    }
//
//    public void setFechaNacimiento(Date fechaNacimiento) {
//        this.fechaNacimiento = fechaNacimiento;
//    }
//
//    public String getContrasenaUsuario() {
//        return contrasenaUsuario;
//    }
//
//    public void setContrasenaUsuario(String contrasenaUsuario) {
//        this.contrasenaUsuario = contrasenaUsuario;
//    }
//
//    public String getEmailUsuario() {
//        return emailUsuario;
//    }
//
//    public void setEmailUsuario(String emailUsuario) {
//        this.emailUsuario = emailUsuario;
//    }
//
//    public Double getEstaturaUsuario() {
//        return estaturaUsuario;
//    }
//
//    public void setEstaturaUsuario(Double estaturaUsuario) {
//        this.estaturaUsuario = estaturaUsuario;
//    }
//
//    public Double getPesoUsuario() {
//        return pesoUsuario;
//    }
//
//    public void setPesoUsuario(Double pesoUsuario) {
//        this.pesoUsuario = pesoUsuario;
//    }
//
//    public Integer getPuntosUsuario() {
//        return puntosUsuario;
//    }
//
//    public void setPuntosUsuario(Integer puntosUsuario) {
//        this.puntosUsuario = puntosUsuario;
//    }
//
//    public Integer getNumeroFicha() {
//        return numeroFicha;
//    }
//
//    public void setNumeroFicha(Integer numeroFicha) {
//        this.numeroFicha = numeroFicha;
//    }
//
//    public Integer getHorasRecompensas() {
//        return horasRecompensas;
//    }
//
//    public void setHorasRecompensas(Integer horasRecompensas) {
//        this.horasRecompensas = horasRecompensas;
//    }
//
//    public Integer getNivelActualUsuario() {
//        return nivelActualUsuario;
//    }
//
//    public void setNivelActualUsuario(Integer nivelActualUsuario) {
//        this.nivelActualUsuario = nivelActualUsuario;
//    }
//
//    public String getQrAdmin() {
//        return qrAdmin;
//    }
//
//    public void setQrAdmin(String qrAdmin) {
//        this.qrAdmin = qrAdmin;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((idRol.getNombreRol())));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
