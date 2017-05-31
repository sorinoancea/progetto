package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utente {
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String nomeUtente;
	private String mail;
	@OneToMany
	private Percorso percosi;
	@OneToMany
	private Amministratore amministratori;
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
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Percorso getPercosi() {
		return percosi;
	}
	public void setPercosi(Percorso percosi) {
		this.percosi = percosi;
	}
	public Amministratore getAmministratori() {
		return amministratori;
	}
	public void setAministratori(Amministratore amministratori) {
		this.amministratori = amministratori;
	}
	
	
	
}
