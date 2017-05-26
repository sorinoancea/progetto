package model;


import javax.persistence.*;
import java.util.*;

@Entity
public class Curatore {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;   
	private String nome;
	private String cognome;
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;
	@OneToMany(mappedBy="curatore")
	private List<Stanza> stanze;
	
	
	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Stanza> getStanze() {
		return stanze;
	}

	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}


}
