package it.giacomo.maestrelli.exlibris.controller;

import java.util.HashSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.giacomo.maestrelli.exlibris.model.Autore;
import it.giacomo.maestrelli.exlibris.model.Editore;
import it.giacomo.maestrelli.exlibris.model.Libro;

/**
 * Session Bean implementation class ExlibrisBean
 */
@Stateless(mappedName = "exlibbean")
@LocalBean
public class ExlibrisBean {

	@PersistenceContext(unitName="ExLibrisTomBe")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void ejbInserisciLibroTest(){
		Autore aut = new Autore();
		aut.setNome("PincoTest");
		aut.setCognome("Pallino Test");
		aut.setDataMorte(new java.util.Date());
		aut.setDataNascita(new java.util.Date());
		aut.setTitoloNobiliare("Sir");
		Libro libro = new Libro();
		libro.setTitolo("Testo di Test");
		HashSet<Autore> a = new HashSet<Autore>();
		a.add(aut);
		libro.setAutori(a);
		Editore edit = new Editore();
		edit.setNome("Casa Editrice Test");
		libro.setEditore(edit);
		em.persist(libro);
		
	}
	
	

}
