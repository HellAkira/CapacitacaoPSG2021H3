package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseRepositorio {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public BaseRepositorio(String nomeUnidade){
		this.emf = Persistence.createEntityManagerFactory(nomeUnidade);
		
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEm() {
		return em;
	}

	
	
}
