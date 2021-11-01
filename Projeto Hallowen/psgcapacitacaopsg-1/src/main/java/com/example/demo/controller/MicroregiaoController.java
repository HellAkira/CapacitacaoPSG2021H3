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

import com.example.demo.model.Microregiao;
import com.example.demo.repository.IMicroregiaoRepository;

@RestController
@RequestMapping(path = "/api")
public class MicroregiaoController {

	@Autowired
	private IMicroregiaoRepository repo;

	@GetMapping("/microregiaos")
	public List<Microregiao> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/microregiaos/{id}")
	public Microregiao getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping("/microregiaos/{inicio}/{fim}")
	public List<Microregiao> getByIDBeetwen(@PathVariable int inicio,@PathVariable int fim) {
		return this.repo.findByMicroregiaoIDBetween(inicio,fim);
	}
	
	@GetMapping("/microregiaos/paginavel")
	public Page<Microregiao> getPorPagina (
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "4") int size
			){
		PageRequest pr = PageRequest.of(page, size);
		System.out.println(pr.getOffset());
		Page<Microregiao> lista = this.repo.findAll(pr);
		return lista;
	}
	
	@PostMapping("/microregiaos")
	public Microregiao post(@RequestBody Microregiao microregiao) {
		//Set ID null para prevenir problema ao colocar um id que ja existe 
		microregiao.setMicroregiaoID(null);
		return this.repo.save(microregiao);
	}

	@DeleteMapping("/microregiaos/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/microregiaos/put")
	public Microregiao put(@RequestBody Microregiao novaMicroregiao) {
		return  this.repo
				.findById(novaMicroregiao.getMicroregiaoID())
				.map(nm -> {
					nm.setMicroregiaoID(novaMicroregiao.getMicroregiaoID());
					nm.setDescricao(novaMicroregiao.getDescricao());
					nm.setSiglaUF(novaMicroregiao.getSiglaUF());
					return this.repo.save(nm);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
