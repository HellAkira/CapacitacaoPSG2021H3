package repositorio;

import java.util.List;

import javax.persistence.Query;

import ancestral.BaseGenericRepository;
import ancestral.IGenericRepository;
import dominio.SubCategoria;

public class SubCategoriaRepositorio 
extends BaseGenericRepository<SubCategoria> 
implements IGenericRepository<SubCategoria> {

	public SubCategoriaRepositorio(String nomeUnidade) {
		super(nomeUnidade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(SubCategoria instance) {
		this.getSession().getTransaction().begin();
		this.getSession().persist(instance);
		this.getSession().getTransaction().commit();

	}

	@Override
	public List<SubCategoria> readAll() {

		Query qry = this.getSession().createQuery("From SubCategoria");
		@SuppressWarnings("unchecked")
		List<SubCategoria> lista = qry.getResultList();

		return lista;
	}

	@Override
	public SubCategoria read(int id) {

		SubCategoria subCat = this.getSession().find(SubCategoria.class, id);
		return subCat;
	}

	@Override
	public SubCategoria update(SubCategoria instance) {
		
		SubCategoria subCat = this.getSession().find(SubCategoria.class, instance.getSubCategoriaID());
		this.getSession().detach(subCat);
		this.getSession().getTransaction().begin();
		SubCategoria mergeSubCategoria = (SubCategoria) this.getSession().merge(instance);
		this.getSession().getTransaction().commit();

		return mergeSubCategoria;
	}
	
	@Override
	public void delete(int id) {
		
		SubCategoria subCat = this.getSession().find(SubCategoria.class, id);
		this.getSession().getTransaction().begin();
		this.getSession().remove(subCat);
		this.getSession().getTransaction().commit();

	}
	
	@Override
	public void delete(SubCategoria instance) {
		
		this.delete(instance.getSubCategoriaID());

	}

}
