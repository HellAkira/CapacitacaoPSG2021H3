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

import com.example.demo.model.Funcionario;
import com.example.demo.repository.IFuncionarioRepository;

@RestController
@RequestMapping(path = "/api")
public class FuncionarioController {

	@Autowired
	private IFuncionarioRepository repo;

	@GetMapping("/funcionarios")
	public List<Funcionario> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/funcionarios/{id}")
	public Funcionario getByID(@PathVariable Integer id) {
		return repo.findById(id).orElse(null);
	}
	@GetMapping("/funcionarios/chave/{id}")
	public Funcionario getByChave(@PathVariable Long id) {
		return this.repo.findByChave(id);
	}

	@PostMapping("/funcionarios")
	public Funcionario post(@RequestBody Funcionario funcionario) {	
		funcionario.setFuncionarioID(repo.findByFuncionarioIDMAX() + 1);
		return this.repo.save(funcionario);
	}	


	@DeleteMapping("/funcionarios/delete/{id}")
	public void delete(@PathVariable Integer id) {
			if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}
	

	@PutMapping("/funcionarios/put")
	public Funcionario put(@RequestBody Funcionario novaFuncionario) {
		return  this.repo
				.findById(novaFuncionario.getFuncionarioID())
				.map(fun -> {
					fun.setFuncionarioID(novaFuncionario.getFuncionarioID());
					fun.setChave(novaFuncionario.getChave());
					fun.setCtps(novaFuncionario.getCtps());
					fun.setEmail(novaFuncionario.getEmail());
					fun.setNascimento(novaFuncionario.getNascimento());
					fun.setNome(novaFuncionario.getNome());
					fun.setSobrenome(novaFuncionario.getSobrenome());
					fun.setNumeroCTPS(novaFuncionario.getNumeroCTPS());
					fun.setPaisID(novaFuncionario.getPaisID());
					fun.setSexo(novaFuncionario.getSexo());
					fun.setAdmissao(novaFuncionario.getAdmissao());
					fun.setInclusao(novaFuncionario.getInclusao());
					fun.setSerieCTPS(novaFuncionario.getSerieCTPS());
					return this.repo.save(fun);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
