package ancestral;

import java.util.List;

public interface IGenericRepository <T>{

	void create(T instance);
	
	List<T> readAll();
	
	T read(int id);
	
	T update(T instance);
	
	void delete(T instance);
	
	void delete(int id);

}
