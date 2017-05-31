package model;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQuery(name="findAll", query="SELECT o FROM opera o")
public class Opera {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;   
	private String titolo;
	@Temporal(TemporalType.DATE)
	private Date annoRealizzazione;
	private String tecnica;
	private float dimensioni;
	@ManyToMany(mappedBy="opere")
	private List <Artista> artisti;
	@OneToMany
	private Amministratore amministratori;
	@ManyToMany
	private Percorso percorsi;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Date getRealizzazione() {
		return annoRealizzazione;
	}
	public void setRealizzazione(Date anno) {
		this.annoRealizzazione = anno;
	}
	public List<Artista> getArtisti() {
		return artisti;
	}
	public void setArtisti(List<Artista> artisti) {
		this.artisti = artisti;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public float getDimensione() {
		return dimensioni;
	}
	public void setDimensione(float f) {
		this.dimensioni = f;
	}
	public Date getAnnoRealizzazione() {
		return annoRealizzazione;
	}
	public void setAnnoRealizzazione(Date annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}
	public float getDimensioni() {
		return dimensioni;
	}
	public void setDimensioni(float dimensioni) {
		this.dimensioni = dimensioni;
	}
	public Amministratore getAmministratore() {
		return amministratori;
	}
	public void setAministratori(Amministratore amministratori) {
		this.amministratori = amministratori;
	}
	public Percorso getPercorsi() {
		return percorsi;
	}
	public void setPercorsi(Percorso percorsi) {
		this.percorsi = percorsi;
	}

	
	
}
