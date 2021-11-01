package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UnidadeFederacao;


public interface IUnidadeFederacaoRepository extends JpaRepository<UnidadeFederacao, Integer> {

	List<UnidadeFederacao> findByUnidadeFederacaoIDBetween(int inicio, int fim);
	
	
	

}
