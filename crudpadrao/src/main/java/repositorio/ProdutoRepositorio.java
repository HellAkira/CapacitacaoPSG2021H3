package repositorio;

import java.util.List;

import javax.persistence.Query;

import Dominio.Produto;

public class ProdutoRepositorio extends BaseRepositorio {

	public ProdutoRepositorio(String nomeUnidade) {
		super(nomeUnidade);
		this.em = this.emf.createEntityManager();

	}

	public void create(Produto produto) {

		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();

	}

	public Produto read(Integer id) {

		Produto pro = this.em.find(Produto.class, id);

		return pro;

	}

	public List<Produto> readAll() {

		Query qry = this.em.createQuery("From Produto");
		@SuppressWarnings("unchecked")
		List<Produto> lista = qry.getResultList();

		return lista;

	}

	public Produto update(Produto produto) {

		Produto pro = this.em.find(Produto.class, produto.getProdutoID());
		this.em.detach(pro);
		this.em.getTransaction().begin();
		Produto mergeProduto = (Produto) this.em.merge(produto);
		this.em.getTransaction().commit();

		return mergeProduto;
	}

	public void dispose() {
		this.em.close();
		this.emf.close();
	}

	public void delete(Integer id) {
		Produto pro = this.em.find(Produto.class, id);
		this.em.getTransaction().begin();
		this.em.remove(pro);
		this.em.getTransaction().commit();

	}

}
