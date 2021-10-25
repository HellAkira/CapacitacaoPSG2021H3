package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.model.Funcionario;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	Funcionario findByChave(Long id);
	
	@Query (value = "select Max (f.FuncionarioID) from Funcionario f", nativeQuery = true)
	Integer findByFuncionarioIDMAX();
	
}
