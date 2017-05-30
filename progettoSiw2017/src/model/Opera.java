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
	private Date periodo;
	private String tecnica;
	private float valore;
	@ManyToMany(mappedBy="opere")
	private List <Artista> artisti;

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
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date anno) {
		this.periodo = anno;
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
	public float getValore() {
		return valore;
	}
	public void setValore(float f) {
		this.valore = f;
	}

}
