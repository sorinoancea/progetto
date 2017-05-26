package model;


import javax.persistence.*;
import java.util.*;

@Entity
public class Stanza {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;   
	private String nome;
	private String piano;
	@OneToMany
	@JoinColumn(name="stanza_id")
	private List<Opera> opere;
	@ManyToOne(fetch=FetchType.EAGER)
	private Curatore curatore;

	
	public String getPiano() {
		return piano;
	}
	public void setPiano(String piano) {
		this.piano = piano;
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
	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	public Curatore getCuratore() {
		return curatore;
	}
	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
	}


}
