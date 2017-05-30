package persistence.jpa;

import java.util.*;
import model.Artista;
import persistence.ArtistaCrudRepository;
import javax.persistence.*;

public class ArtistaCrudRepositoryJPA implements ArtistaCrudRepository {
	//finche non importi i metodi della classe implmenets interfaccia da errore
	private EntityManager em;
	private EntityTransaction tx;

	//creato all esterno i entitymanager e transaction altrimenti
	//avremmo problemi come quelli con la compagnia cinse
	public ArtistaCrudRepositoryJPA(EntityManager em /*EntityTransaction tx*/) {
		this.em = em;
		//this.tx =tx;
	}


	@Override
	public Artista save(Artista artista) {

		if(artista.getId() == null){
			em.persist(artista);
		}else{
			/*ci ritorna una copia di un oggetto 
			 * che è managed...se managed le modifiche vengono
			 *  sincronizzate con il db
			 */
			return em.merge(artista);   //
		}
		return artista;
	}
	/*
	 * metodo find fa da solo la query
	 * @see persistence.ArtistaCrudRepository#findOne(java.lang.Long)
	 */

	@Override
	public Artista findOne(Long id) {
		return em.find(Artista.class , id); 
	}

	@Override
	public List<Artista> findALL() {
		Query query= em.createQuery("SELECT a FROM artista a");  //interrogo con query
		return query.getResultList();	
	}

	@Override
	public void delete(Artista artista) {
		em.remove(artista);		
	}

	@Override
	public void deleteAll(){
		Query query =em.createQuery("DELETE FROM artista");
		query.executeUpdate(); //esegue la query
	}

}
