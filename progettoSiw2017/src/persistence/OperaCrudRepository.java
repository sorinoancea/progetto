package persistence;

import java.util.*;
import model.Opera;

//OperaCrudRepositiry
//introdotto il generic al posto del tipo opera
public interface OperaCrudRepository {


	public Opera save(Opera opera);
	public Opera findOne(Long id); 
	public List<Opera> findALL();    //restituisce tutte le opere con findAll
	public void delete(Opera opera);
	public void deleteAll();
}
