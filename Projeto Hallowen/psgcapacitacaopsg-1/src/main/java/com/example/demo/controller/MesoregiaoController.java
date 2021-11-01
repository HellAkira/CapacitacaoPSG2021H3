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

import com.example.demo.model.Mesoregiao;
import com.example.demo.repository.IMesoregiaoRepository;

@RestController
@RequestMapping(path = "/api")
public class MesoregiaoController {

	@Autowired
	private IMesoregiaoRepository repo;

	@GetMapping("/mesoregiaos")
	public List<Mesoregiao> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/mesoregiaos/{id}")
	public Mesoregiao getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping("/mesoregiaos/{inicio}/{fim}")
	public List<Mesoregiao> getByIDBeetwen(@PathVariable int inicio,@PathVariable int fim) {
		return this.repo.findByMesoregiaoIDBetween(inicio,fim);
	}
	
	@GetMapping("/mesoregiaos/paginavel")
	public Page<Mesoregiao> getPorPagina (
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "4") int size
			){
		PageRequest pr = PageRequest.of(page, size);
		System.out.println(pr.getOffset());
		Page<Mesoregiao> lista = this.repo.findAll(pr);
		return lista;
	}
	
	@PostMapping("/mesoregiaos")
	public Mesoregiao post(@RequestBody Mesoregiao mesoregiao) {
		//Set ID null para prevenir problema ao colocar um id que ja existe 
		mesoregiao.setMesoregiaoID(null);
		return this.repo.save(mesoregiao);
	}

	@DeleteMapping("/mesoregiaos/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/mesoregiaos/put")
	public Mesoregiao put(@RequestBody Mesoregiao novaMesoregiao) {
		return  this.repo
				.findById(novaMesoregiao.getMesoregiaoID())
				.map(nm -> {
					nm.setMesoregiaoID(novaMesoregiao.getMesoregiaoID());
					nm.setDescricao(novaMesoregiao.getDescricao());
					nm.setSiglaUF(novaMesoregiao.getSiglaUF());
					return this.repo.save(nm);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
