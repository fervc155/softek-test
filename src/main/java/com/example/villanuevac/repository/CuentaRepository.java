package com.example.villanuevac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.villanuevac.DTO.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
	
}
