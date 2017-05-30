package persistence;

import java.util.List;

import model.Stanza;


public interface StanzaCrudRepository {
	
	public Stanza save(Stanza stanza);
	public Stanza findOne(Long id); 
	public List<Stanza> findALL();    //restituisce tutte le stanza con findAll
	public void delete(Stanza stanza);
	public void deleteAll();

}
