package it.giacomo.maestrelli.exlibris.controller;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import it.giacomo.maestrelli.exlibris.model.interfaccia.JsonPojo;



/**
 * Session Bean implementation class GoogleApiSingletonBean
 */
@Singleton
@LocalBean
public class GoogleApiSingletonBean {

	
	private static String ISBNconnectionString = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
    
	private Client cl;
	
	/**
     * Default constructor. 
     */
    public GoogleApiSingletonBean() {
        cl = ClientBuilder.newClient(); 	
    }
    
   @Lock(LockType.READ)
   public JsonPojo  retrieveJsonPojoBooks(String isbn)
   {
	   if(isbn==null)return null;
	   WebTarget wt = cl.target(ISBNconnectionString+isbn);
	   return wt.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get( JsonPojo.class);   
   }
   

}
