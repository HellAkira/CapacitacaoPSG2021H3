package servico;

import java.util.List;

import ancestral.BaseGenericService;
import ancestral.IGerenericService;
import dominio.Produto;
import repositorio.ProdutoRepositorio;

public class ProdutoServico 
extends BaseGenericService<ProdutoRepositorio>
implements IGerenericService<Produto> {

	public ProdutoServico(String nomeUnidade) {
		super(nomeUnidade);
		this.getRepositorio();
		this.repositorio = new ProdutoRepositorio(this.nomeUnidade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Produto instance) {
		repositorio.create(instance);
		
	}

	@Override
	public void alterar(Produto instance) {
		repositorio.update(instance);
		
	}

	@Override
	public void excluir(Produto instance) {
		repositorio.delete(instance);
		
	}

	@Override
	public void excluir(int id) {
		repositorio.delete(id);
		
	}

	@Override
	public List<Produto> listar() {

		return repositorio.readAll();
	}

	@Override
	public Produto obter(int id) {
		return repositorio.read(id);
	}
	
	public void dispose() {
		repositorio.dispose();
	}
}
