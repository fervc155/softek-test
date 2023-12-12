package com.example.villanuevac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.villanuevac.DTO.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
}
