package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.demo.model.SubCategoria;

public interface ISubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {
	
	List<SubCategoria>findByCategoriaID(int catid);

}
