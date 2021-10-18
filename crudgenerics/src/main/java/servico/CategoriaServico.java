package servico;

import java.util.List;

import ancestral.BaseGenericService;
import ancestral.IGerenericService;
import dominio.Categoria;
import repositorio.CategoriaRepositorio;

public class CategoriaServico 
extends BaseGenericService<CategoriaRepositorio>
implements IGerenericService<Categoria> {

	public CategoriaServico(String nomeUnidade) {
		super(nomeUnidade);
		this.getRepositorio();
		this.repositorio = new CategoriaRepositorio(this.nomeUnidade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Categoria instance) {
		repositorio.create(instance);
		
	}

	@Override
	public void alterar(Categoria instance) {
		repositorio.update(instance);
		
	}

	@Override
	public void excluir(Categoria instance) {
		repositorio.delete(instance);
		
	}

	@Override
	public void excluir(int id) {
		repositorio.delete(id);
		
	}

	@Override
	public List<Categoria> listar() {

		return repositorio.readAll();
	}

	@Override
	public Categoria obter(int id) {
		return repositorio.read(id);
	}
	
	public void dispose() {
		repositorio.dispose();
	}

}
