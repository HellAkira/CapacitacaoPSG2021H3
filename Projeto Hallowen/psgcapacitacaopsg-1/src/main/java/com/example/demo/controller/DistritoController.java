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

import com.example.demo.model.Distrito;
import com.example.demo.repository.IDistritoRepository;

@RestController
@RequestMapping(path = "/api")
public class DistritoController {

	@Autowired
	private IDistritoRepository repo;

	@GetMapping("/distritos")
	public List<Distrito> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/distritos/{id}")
	public Distrito getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping("/distritos/{inicio}/{fim}")
	public List<Distrito> getByIDBeetwen(@PathVariable int inicio,@PathVariable int fim) {
		return this.repo.findByDistritoIDBetween(inicio,fim);
	}
	
	@GetMapping("/distritos/paginavel")
	public Page<Distrito> getPorPagina (
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "4") int size
			){
		PageRequest pr = PageRequest.of(page, size);
		Page<Distrito> lista = this.repo.findAll(pr);
		return lista;
	
	}
	
	@PostMapping("/distritos")
	public Distrito post(@RequestBody Distrito distrito) {
		distrito.setDistritoID(null);
		return this.repo.save(distrito);
	}

	@DeleteMapping("/distritos/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/distritos/put")
	//Set ID null para prevenir problema ao colocar um id que ja existe 
	public Distrito put(@RequestBody Distrito novaDistrito) {
		return  this.repo
				.findById(novaDistrito.getDistritoID())
				.map(nm -> {
					nm.setDistritoID(novaDistrito.getDistritoID());
					nm.setDescricao(novaDistrito.getDescricao());
					nm.setSiglaUF(novaDistrito.getSiglaUF());
					return this.repo.save(nm);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
