package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Integer> {
	
	List<Produto>findByCategoriaID(int id);
	List<Produto>findBySubCategoriaID(int id);
	List<Produto> findBySubCategoriaIDAndCategoriaID(int catid, int id);
}
