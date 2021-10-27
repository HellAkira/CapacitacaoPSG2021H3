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

import com.example.demo.model.DepartamentoPorFuncionario;
import com.example.demo.repository.IDepartamentoPorFuncionarioRepository;

@RestController
@RequestMapping(path = "/api")
public class DepartamentoPorFuncionarioController {

	@Autowired
	private IDepartamentoPorFuncionarioRepository repo;

	@GetMapping("/departamentoporfuncionario")
	public List<DepartamentoPorFuncionario> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/departamentoporfuncionario/{id}")
	public DepartamentoPorFuncionario getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@GetMapping("/departamentoporfuncionario/departamento/{id}")
	public List<DepartamentoPorFuncionario> getByDepartamentoID(@PathVariable int id) {
		return this.repo.findByDepartamentoID(id);
	}	
	
	@GetMapping("/departamentoporfuncionario/funcionario/{id}")
	public List<DepartamentoPorFuncionario> getByFuncionarioID(@PathVariable int id) {
		return this.repo.findByFuncionarioID(id);
	}

	@PostMapping("/departamentoporfuncionario")
	public DepartamentoPorFuncionario post(@RequestBody DepartamentoPorFuncionario departamento) {
		return this.repo.save(departamento);
	}
	
	@GetMapping("/departamentoporfuncionario/{inicio}/{fim}")
	public List<DepartamentoPorFuncionario> getBeetwen(@PathVariable Integer inicio, @PathVariable Integer fim){
		return repo.findByDepartamentoPorFuncionarioIDBetween(inicio, fim);
		
	}
	
	@DeleteMapping("/departamentoporfuncionario/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/departamentoporfuncionario/put")
	public DepartamentoPorFuncionario put(@RequestBody DepartamentoPorFuncionario novaDepartamento) {
		return  this.repo
				.findById(novaDepartamento.getDepartamentoPorFuncionarioID())
				.map(dep -> {
					dep.setDepartamentoPorFuncionarioID(novaDepartamento.getDepartamentoPorFuncionarioID());
					dep.setDepartamentoID(novaDepartamento.getDepartamentoID());
					dep.setFuncionarioID(novaDepartamento.getFuncionarioID()); 
					dep.setDataFim(novaDepartamento.getDataFim());
					dep.setDataInicio(novaDepartamento.getDataInicio());
					return this.repo.save(dep);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
