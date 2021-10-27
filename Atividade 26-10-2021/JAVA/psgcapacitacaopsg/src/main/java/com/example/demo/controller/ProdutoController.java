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

import com.example.demo.model.Produto;
import com.example.demo.repository.IProdutoRepository;

@RestController
@RequestMapping(path = "/api")
public class ProdutoController {

	@Autowired
	private IProdutoRepository repo;

	@GetMapping("/produtos")
	public List<Produto> getAll() {
		return this.repo.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Produto getByID(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@GetMapping("/subcategorias/{id}/produtos")
	public List<Produto> getBySubCatID(@PathVariable int id) {
		return this.repo.findBySubCategoriaID(id);
	}	
	
	
	@GetMapping("/categorias/{catid}/produtos")
	public List<Produto> getByCatID(@PathVariable int catid) {
		return this.repo.findByCategoriaID(catid);
	}
	
	@GetMapping("/categorias/{subcatid}/{catid}/produtos")
	public List<Produto> getByCatSubCatID(@PathVariable int catid,@PathVariable int subcatid) {
		return this.repo.findBySubCategoriaIDAndCategoriaID(catid,subcatid);
	}

	@PostMapping("/produtos")
	public Produto post(@RequestBody Produto produto) {
		return this.repo.save(produto);
	}

	@DeleteMapping("/produtos/delete/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping("/produtos/put")
	public Produto put(@RequestBody Produto novaProduto) {
		return  this.repo
				.findById(novaProduto.getProdutoID())
				.map(pro -> {
					pro.setProdutoID(novaProduto.getProdutoID());
					pro.setCategoriaID(novaProduto.getCategoriaID());
					pro.setSubCategoriaID(novaProduto.getSubCategoriaID());
					pro.setDescricao(novaProduto.getDescricao());
					pro.setDataDeInsercao(novaProduto.getDataDeInsercao());
					return this.repo.save(pro);
				})
				.orElse(null);
	}

	
	
	
	
	
	
	
}
