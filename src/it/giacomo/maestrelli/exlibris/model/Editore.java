package it.giacomo.maestrelli.exlibris.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Editore
 *
 */
@Entity
@Table(name="editori")

public class Editore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="editori_seq",sequenceName="editori_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="editori_seq")
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy="editore",cascade=CascadeType.PERSIST)
	private Collection<Libro> libri;
	
	@OneToMany(mappedBy="editore",cascade=CascadeType.PERSIST)
	private Collection<Collana> collane;

	public Editore() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Collection<Libro> getLibri() {
		return this.libri;
	}

	public void setLibri(Collection<Libro> libri) {
		this.libri = libri;
	}   
	public Collection<Collana> getCollane() {
		return this.collane;
	}

	public void setCollane(Collection<Collana> collane) {
		this.collane = collane;
	}
   
}
