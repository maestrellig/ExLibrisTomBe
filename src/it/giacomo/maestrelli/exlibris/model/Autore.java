package it.giacomo.maestrelli.exlibris.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Autore
 *
 */
@Entity
@Table(name="autori")
public class Autore implements Serializable {

	
	@Id
	@SequenceGenerator(name="autori_seq",sequenceName="autori_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="autori_seq")
	private Long id;
	
	@ManyToMany(mappedBy="autori", cascade=CascadeType.PERSIST)
	private Collection<Libro> libri;
	
	private String nome;
	private String cognome;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	private String titoloNobiliare;
	
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	
	private String secondoNome;
	private static final long serialVersionUID = 1L;

	public Autore() {
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
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}   
	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}   
	public String getTitoloNobiliare() {
		return this.titoloNobiliare;
	}

	public void setTitoloNobiliare(String titoloNobiliare) {
		this.titoloNobiliare = titoloNobiliare;
	}   
	public Date getDataMorte() {
		return this.dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}   
	public String getSecondoNome() {
		return this.secondoNome;
	}

	public void setSecondoNome(String secondoNome) {
		this.secondoNome = secondoNome;
	}
   
}
