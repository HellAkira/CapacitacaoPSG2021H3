package ancestral;

public abstract class BaseGenericService <R> {
	
	protected R repositorio;
	
	protected String nomeUnidade;
	
	public BaseGenericService(String nomeUnidade) {
		
		this.nomeUnidade = nomeUnidade;
	}
	
	public R getRepositorio() {
		
		return this.repositorio;
		
	}
	
	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void dispose() {
		
	}
	

}
