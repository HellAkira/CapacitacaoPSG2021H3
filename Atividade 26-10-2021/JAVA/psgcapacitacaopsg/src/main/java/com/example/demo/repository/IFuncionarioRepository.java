package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Funcionario;


public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	Funcionario findByChave(Long id);
	
	@Query (value = "select Max (f.FuncionarioID) from Funcionario f", nativeQuery = true)
	Integer findByFuncionarioIDMAX();
	
	@Query (value = "select * from Funcionario f where FuncionarioID BETWEEN :inicio AND :fim", nativeQuery = true)
	List<Funcionario> findByFuncionarioIDBetweenCaseiro(@Param("inicio") int inicio,@Param("fim") int fim);
	
	
}
