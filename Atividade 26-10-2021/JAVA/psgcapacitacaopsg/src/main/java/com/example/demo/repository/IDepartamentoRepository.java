package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Departamento;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {
	
	@Query(value = "select Max (f.DepartamentoID) from DepartamentoID f", nativeQuery = true)
	Integer findByDepartamentoIDMAX();
	
	List<Departamento>findByDepartamentoIDBetween(int inicio, int fim);
	

}
