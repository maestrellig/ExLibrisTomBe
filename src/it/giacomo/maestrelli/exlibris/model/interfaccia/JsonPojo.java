package it.giacomo.maestrelli.exlibris.model.interfaccia;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Libro")
public class JsonPojo {

	@XmlElement(name = "itempresenti")
	int totalItems;
	
	
}
