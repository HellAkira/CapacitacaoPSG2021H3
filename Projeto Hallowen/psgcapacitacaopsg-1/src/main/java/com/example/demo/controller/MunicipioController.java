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

import com.example.demo.model.Municipio;
import com.example.demo.repository.IMunicipioRepository;

@RestController
@RequestMapping(path = "/api")
public class MunicipioController {

	@Autowired
	private IMunicipioRepository repo;

	@GetMapping("/municipios")
	public List<Municipio> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/municipios/{id}")
	public Municipio getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping("/municipios/{inicio}/{fim}")
	public List<Municipio> getByIDBeetwen(@PathVariable int inicio,@PathVariable int fim) {
		return this.repo.findByMunicipioIDBetween(inicio,fim);
	}
	
	@GetMapping("/municipios/paginavel")
	public Page<Municipio> getPorPagina (
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "4") int size
			){
		PageRequest pr = PageRequest.of(page, size);
		System.out.println(pr.getOffset());
		Page<Municipio> lista = this.repo.findAll(pr);
		return lista;
	}
	
	@PostMapping("/municipios")
	public Municipio post(@RequestBody Municipio municipio) {
		//Set ID null para prevenir problema ao colocar um id que ja existe 
		municipio.setMunicipioID(null);
		return this.repo.save(municipio);
	}

	@DeleteMapping("/municipios/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/municipios/put")
	public Municipio put(@RequestBody Municipio novaMunicipio) {
		return  this.repo
				.findById(novaMunicipio.getMunicipioID())
				.map(nm -> {
					nm.setMunicipioID(novaMunicipio.getMunicipioID());
					nm.setDescricao(novaMunicipio.getDescricao());
					nm.setSiglaUF(novaMunicipio.getSiglaUF());
					return this.repo.save(nm);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
