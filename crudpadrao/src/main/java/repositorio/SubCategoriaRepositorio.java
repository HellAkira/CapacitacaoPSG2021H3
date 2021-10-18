package repositorio;

import java.util.List;

import javax.persistence.Query;

import Dominio.SubCategoria;

public class SubCategoriaRepositorio extends BaseRepositorio {

	public SubCategoriaRepositorio(String nomeUnidade) {
		super(nomeUnidade);
		this.em = this.emf.createEntityManager();
	}

	public void create(SubCategoria subCat) {
		this.em.getTransaction().begin();
		this.em.persist(subCat);
		this.em.getTransaction().commit();

	}

	public SubCategoria read(Integer id) {
		SubCategoria subCat = this.em.find(SubCategoria.class, id);

		return subCat;
	}

	public List<SubCategoria> readAll() {
		Query qry = this.em.createQuery("From SubCategoria");
		@SuppressWarnings("unchecked")
		List<SubCategoria> lista = qry.getResultList();

		return lista;

	}

	public SubCategoria update(SubCategoria subCategoria) {
		SubCategoria subCat = this.em.find(SubCategoria.class, subCategoria.getSubCategoriaID());
		this.em.detach(subCat);
		this.em.getTransaction().begin();
		SubCategoria mergeSubCategoria = (SubCategoria) this.em.merge(subCategoria);
		this.em.getTransaction().commit();
		return mergeSubCategoria;
	}

	public void dispose() {
		this.em.close();
		this.emf.close();
	}

	public void delete(Integer id) {
		SubCategoria subCat = this.em.find(SubCategoria.class, id);
		this.em.detach(subCat);
		this.em.getTransaction().begin();
		this.em.remove(subCat);
		this.em.getTransaction().commit();

	}

}
