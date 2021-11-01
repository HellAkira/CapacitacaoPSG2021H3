package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Mesoregiao;


public interface IMesoregiaoRepository extends JpaRepository<Mesoregiao, Integer> {

	List<Mesoregiao> findByMesoregiaoIDBetween(int inicio, int fim);


}
