package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Microregiao;

public interface IMicroregiaoRepository extends JpaRepository<Microregiao, Integer>{

	List<Microregiao> findByMicroregiaoIDBetween(int inicio, int fim);

}
