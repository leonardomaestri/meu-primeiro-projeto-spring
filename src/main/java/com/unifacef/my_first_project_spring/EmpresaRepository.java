package com.unifacef.my_first_project_spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacef.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Empresa findByCnpj(String cnpj);
}