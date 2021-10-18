package Servico;

//import java.util.Date;
import java.util.List;

import Dominio.Produto;
import repositorio.ProdutoRepositorio;

public class ProdutoServico extends BaseServico {

	private ProdutoRepositorio repo;

	public ProdutoServico(ProdutoRepositorio repo) {

		this.repo = repo;

	}

	public void alterar(Produto pro) {

		repo.update(pro);

	}

	public void excluir(Produto pro) {

		repo.delete(pro.getProdutoID());

	}

	public void excluirPorID(Integer id) {
		repo.delete(id);
	}

	public void inserir(Produto pro) {

		repo.create(pro);

	}

	public List<Produto> listar() {

		return repo.readAll();

	}

	public Produto obter(Integer id) {

		return repo.read(id);

	}

}
