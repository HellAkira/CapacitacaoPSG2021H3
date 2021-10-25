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

import com.example.demo.model.SubCategoria;
import com.example.demo.repository.ISubCategoriaRepository;

@RestController
@RequestMapping(path = "/api")
public class SubCategoriaController {

	@Autowired
	private ISubCategoriaRepository repo;

	@GetMapping(path = "subcategorias")
	public List<SubCategoria> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("subcategorias/{id}")
	public SubCategoria getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@GetMapping("categorias/{id}/subcategorias")
	public List<SubCategoria> getByCatID(@PathVariable int id) {
		return this.repo.findByCategoriaID(id);
	}
	
	@PostMapping("/subcategorias")
	public SubCategoria post(@RequestBody SubCategoria subCategoria) {
		return this.repo.save(subCategoria);
	}

	@DeleteMapping("/subcategorias/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/subcategorias/put")
	public SubCategoria put(@RequestBody SubCategoria novaSubCategoria) {

		return  this.repo
				.findById(novaSubCategoria.getSubCategoriaID())
				.map(subCat -> {
					subCat.setSubCategoriaID(novaSubCategoria.getSubCategoriaID());
					subCat.setCategoriaID(novaSubCategoria.getCategoriaID());
					subCat.setDescricao(novaSubCategoria.getDescricao());
					subCat.setDataDeInsercao(novaSubCategoria.getDataDeInsercao());
					return this.repo.save(subCat);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
