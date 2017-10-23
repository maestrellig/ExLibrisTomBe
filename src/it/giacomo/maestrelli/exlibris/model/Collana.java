package it.giacomo.maestrelli.exlibris.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Collana
 *
 */
@Entity
@Table(name="collane")
public class Collana implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="collana_seq")
	@SequenceGenerator(name="collana_seq",sequenceName="collana_seq",allocationSize=1)
	private Long id;
	
	@OneToMany(mappedBy="collana",cascade=CascadeType.PERSIST)
	private Collection<Libro> libri;
	
	@ManyToOne
	private Editore editore;
	
	private String nome;


	public Collana() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Collection<Libro> getLibri() {
		return this.libri;
	}

	public void setLibri(Collection<Libro> libri) {
		this.libri = libri;
	}   
	public Editore getEditore() {
		return this.editore;
	}

	public void setEditore(Editore editore) {
		this.editore = editore;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
}
