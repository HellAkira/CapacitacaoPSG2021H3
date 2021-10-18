package repositorio;

import java.util.List;

import javax.persistence.Query;

import ancestral.BaseGenericRepository;
import ancestral.IGenericRepository;
import dominio.Produto;

public class ProdutoRepositorio 
extends BaseGenericRepository<Produto> 
implements IGenericRepository<Produto> {

	public ProdutoRepositorio(String nomeUnidade) {
		super(nomeUnidade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Produto instance) {
		this.getSession().getTransaction().begin();
		this.getSession().persist(instance);
		this.getSession().getTransaction().commit();

	}

	@Override
	public List<Produto> readAll() {

		Query qry = this.getSession().createQuery("From Produto");
		@SuppressWarnings("unchecked")
		List<Produto> lista = qry.getResultList();

		return lista;
	}

	@Override
	public Produto read(int id) {

		Produto pro = this.getSession().find(Produto.class, id);
		return pro;
	}

	@Override
	public Produto update(Produto instance) {
		
		Produto pro = this.getSession().find(Produto.class, instance.getProdutoID());
		this.getSession().detach(pro);
		this.getSession().getTransaction().begin();
		Produto mergeProduto = (Produto) this.getSession().merge(instance);
		this.getSession().getTransaction().commit();

		return mergeProduto;
	}
	
	@Override
	public void delete(int id) {
		
		Produto pro = this.getSession().find(Produto.class, id);
		this.getSession().getTransaction().begin();
		this.getSession().remove(pro);
		this.getSession().getTransaction().commit();

	}
	
	@Override
	public void delete(Produto instance) {
		
		this.delete(instance.getProdutoID());

	}

}
