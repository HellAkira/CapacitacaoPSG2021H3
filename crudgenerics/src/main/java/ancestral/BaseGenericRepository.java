package ancestral;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseGenericRepository <T> {
	
	private EntityManagerFactory factory;
	private EntityManager session;
	
	public EntityManagerFactory getFactory() {
		return factory;
	}
	public EntityManager getSession() {
		return session;
	}
	
	public BaseGenericRepository(String nomeUnidade){
		this.factory = Persistence.createEntityManagerFactory(nomeUnidade);
		this.session = this.factory.createEntityManager();
	}
	public void dispose() {
		this.session.close();
		this.factory.close();
	}


}
