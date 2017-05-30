package persistence;

import java.util.List;

public interface CrudRepository<T> {

	public T save(T entity);
	public T findOne(Long id); 
	public List<T> findALL();    
	public void delete(T entity);
	public void deleteAll();
}
