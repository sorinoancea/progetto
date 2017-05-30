package persistence.jpa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.CrudRepository;

/*
 * no framework magic 
 */

public class CrudRepositoryJPA<T> implements CrudRepository<T>{

	private EntityManager em;
	private Class<T> entityClass;

	public CrudRepositoryJPA(EntityManager em,Class<T> entityClass){
		this.em=em;
		this.entityClass= entityClass;
	}

	private String getClassName(){
		String className= this.entityClass.getCanonicalName();
		TypedQuery<T> query =em.createQuery("SELECT e FROM "+ className+ "e",this.entityClass);

		return className;
	}

	
	@Override
	public T save(T entity) {
		Method getId = null;
		T persistentEntity =null;

		try{
			getId = this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException |SecurityException e){
			e.printStackTrace();;
		}


		try{
			if(getId.invoke(entity) == null){
				em.persist(entity);
			}else{
				return em.merge(entity);
			}

		}catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
			e.printStackTrace();
		}

		return entity;			
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass , id);
	}

	@Override
	public List<T> findALL() {
		TypedQuery<T> query =em.createQuery("SELECT e FROM "+this.getClassName()+ "e",this.entityClass);
		return query.getResultList();
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);

	}

	@Override
	public void deleteAll() {
		TypedQuery<T> query =em.createQuery("DELETE FROM artista"+this.getClassName() + "e" , this.entityClass);
		query.executeUpdate(); //esegue la query
	}

	protected EntityManager getEm() {
		return this.em;
	}

}
