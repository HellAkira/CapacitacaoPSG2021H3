package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Departamento;
import com.example.demo.repository.IDepartamentoRepository;

@RestController
@RequestMapping(path = "/api")
public class DepartamentoController {

	@Autowired
	private IDepartamentoRepository repo;

	@GetMapping("/departamentos")
	public List<Departamento> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/departamentos/{id}")
	public Departamento getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@GetMapping("/departamentos/{inicio}/{fim}")
	public List<Departamento> getByDepartamentoIDEntre(@PathVariable int inicio, @PathVariable int fim) {
		return this.repo.findByDepartamentoIDBetween(inicio, fim);
	}
	
	@PostMapping("/departamentos")
	public Departamento post(@RequestBody Departamento departamento) {
		return this.repo.save(departamento);
	}

	@DeleteMapping("/departamentos/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}
	
	@PutMapping("/departamentos/put")
	public Departamento put(@RequestBody Departamento novaDepartamento) {
		return  this.repo
				.findById(novaDepartamento.getDepartamentoID())
				.map(dep -> {
					dep.setDepartamentoID(novaDepartamento.getDepartamentoID());
					dep.setDescricao(novaDepartamento.getDescricao());
					dep.setInclusao(novaDepartamento.getInclusao());
					return this.repo.save(dep);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
