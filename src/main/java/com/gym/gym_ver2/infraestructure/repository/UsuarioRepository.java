package com.gym.gym_ver2.infraestructure.repository;

import com.gym.gym_ver2.domain.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
