package ancestral;

import java.util.List;

public interface IGerenericService <T>{

	void inserir(T instance);
	
	void alterar(T instance);
	
	void excluir(T instance);
	
	void excluir (int id);
	
	List<T> listar();
	
	T obter(int id );
	
	void dispose();
}
