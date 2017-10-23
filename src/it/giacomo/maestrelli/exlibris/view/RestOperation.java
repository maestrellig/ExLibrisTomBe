package it.giacomo.maestrelli.exlibris.view;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import it.giacomo.maestrelli.exlibris.controller.ExlibrisBean;
import it.giacomo.maestrelli.exlibris.controller.GoogleApiSingletonBean;
import it.giacomo.maestrelli.exlibris.model.interfaccia.JsonPojo;

@Path("/operation")
public class RestOperation {
	
	@EJB
	private ExlibrisBean elb;
	
	@EJB
	private GoogleApiSingletonBean gasb;
	
	/**
	 * Powered by google method: cerca un isbn nello sconfinato repository google
	 * Restituisce l'oggetto trovato (in formato JSON)
	 * 
	 * @param isbn
	 * @return
	 */
	@GET
	@Path("/googlejson")
	@Produces({"application/json;charset=UTF-8","application/xml;charset=UTF-8"})
	public JsonPojo findByISBNJson(@QueryParam("isbn") String isbn )
	{
		return gasb.retrieveJsonPojoBooks(isbn);
	}
}
