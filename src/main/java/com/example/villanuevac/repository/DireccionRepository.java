package com.example.villanuevac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.villanuevac.DTO.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
	
}
