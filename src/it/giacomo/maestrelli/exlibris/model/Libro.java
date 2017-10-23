package it.giacomo.maestrelli.exlibris.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity
@Table(name="libri")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="libri_seq",sequenceName="libri_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="libri_seq")
	private Long id;
	
	@ManyToMany( cascade=CascadeType.PERSIST)
	@JoinTable(name="LIBRI_AUTORI",joinColumns=@JoinColumn(name="LIBRI_ID")
		,inverseJoinColumns=@JoinColumn(name="AUTORI_ID"))
	private Collection<Autore> autori;
	
	@ManyToOne(cascade=CascadeType.PERSIST) 
	private Editore editore;
	
	private String titolo;
	/*Iban ?*/
	private String urn;
	
	private String url;
	
	@ManyToOne
	private Collana collana;
	
	private Double prezzo;
	
	public Collana getCollana() {
		return collana;
	}
	public void setCollana(Collana collana) {
		this.collana = collana;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getUrn() {
		return urn;
	}
	public void setUrn(String urn) {
		this.urn = urn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Libro() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Collection<Autore> getAutori() {
		return this.autori;
	}

	public void setAutori(Collection<Autore> autori) {
		this.autori = autori;
	}   
	public Editore getEditore() {
		return this.editore;
	}

	public void setEditore(Editore editore) {
		this.editore = editore;
	}
   
}
