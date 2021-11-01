package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UnidadeFederacao;
import com.example.demo.repository.IUnidadeFederacaoRepository;

@RestController
@RequestMapping(path = "/api")
public class UnidadeFederacaoController {

	@Autowired
	private IUnidadeFederacaoRepository repo;

	@GetMapping("/unidadeFederacaos")
	public List<UnidadeFederacao> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/unidadeFederacaos/{id}")
	public UnidadeFederacao getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping("/unidadeFederacaos/{inicio}/{fim}")
	public List<UnidadeFederacao> getByIDBetween(@PathVariable int inicio,@PathVariable int fim) {
		return this.repo.findByUnidadeFederacaoIDBetween(inicio,fim);
	}
	
	@GetMapping("/unidadeFederacaos/paginavel")
	public Page<UnidadeFederacao> getPorPagina (
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "4") int size
			){
		PageRequest pr = PageRequest.of(page, size);
		System.out.println(pr.getOffset());
		Page<UnidadeFederacao> lista = this.repo.findAll(pr);
		return lista;
	}
	
	@PostMapping("/unidadeFederacaos")
	public UnidadeFederacao post(@RequestBody UnidadeFederacao unidadeFederacao) {
		//Set ID null para prevenir problema ao colocar um id que ja existe 
		unidadeFederacao.setUnidadeFederacaoID(null);
		return this.repo.save(unidadeFederacao);
	}

	@DeleteMapping("/unidadeFederacaos/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/unidadeFederacaos/put")
	public UnidadeFederacao put(@RequestBody UnidadeFederacao novaUnidadeFederacao) {
		return  this.repo
				.findById(novaUnidadeFederacao.getUnidadeFederacaoID())
				.map(nuf -> {
					nuf.setUnidadeFederacaoID(novaUnidadeFederacao.getUnidadeFederacaoID());
					nuf.setDescricao(novaUnidadeFederacao.getDescricao());
					nuf.setSiglaUF(novaUnidadeFederacao.getSiglaUF());
					nuf.setRegiaoBrasil(novaUnidadeFederacao.getRegiaoBrasil());
					return this.repo.save(nuf);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
