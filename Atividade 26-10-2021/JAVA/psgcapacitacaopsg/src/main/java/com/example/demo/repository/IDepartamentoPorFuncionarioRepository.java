package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.DepartamentoPorFuncionario;

public interface IDepartamentoPorFuncionarioRepository extends JpaRepository<DepartamentoPorFuncionario, Integer> {
	
	@Query (value = "select Max (f.DepartamentoPorFuncionarioID) from DepartamentoPorFuncionarioID f", nativeQuery = true)
	Integer findByFuncionarioIDMAX();
	
	List<DepartamentoPorFuncionario>findByDepartamentoPorFuncionarioIDBetween(int inicio, int fim);
	List<DepartamentoPorFuncionario> findByDepartamentoID(Integer departamentoID);
	List<DepartamentoPorFuncionario> findByFuncionarioID(Integer funcionarioID);
	
	
}
