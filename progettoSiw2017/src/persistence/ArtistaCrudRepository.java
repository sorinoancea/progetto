package persistence;

import java.util.*;
import model.Artista;

//ArtistaCrudRepositiry
//introduco il generic al posto del tipo artista
public interface ArtistaCrudRepository {

	/**/
	public Artista save(Artista artista);   //salva oppure aggiorna una tupla, esistente o meno, create/update
	public Artista findOne(Long id); 
	public List<Artista> findALL();    //restituisce tutti i artisti con findAll
	public void delete(Artista artista);
    public void deleteAll();
	
}
