package it.objectmethod.generaXml.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//forse senza namespace
@XmlRootElement(name="FatturaElettronica", namespace="http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2")  
@XmlType(propOrder = { "fatturaElettronicaHeader", "fatturaElettronicaBody"})
public class FatturaElettronica {

	private static final long serialVersionUID = 1L;
	private FatturaElettronicaHeader fatturaElettronicaHeader;
	private FatturaElettronicaBody fatturaElettronicaBody;
	

	@XmlElement(name = "FatturaElettronicaHeader")
	public FatturaElettronicaHeader getFatturaElettronicaHeader() {
		return fatturaElettronicaHeader;
	}

	public void setFatturaElettronicaHeader(FatturaElettronicaHeader fatturaElettronicaHeader) {
		this.fatturaElettronicaHeader = fatturaElettronicaHeader;
	}
	
	
	
	@XmlElement(name = "FatturaElettronicaBody")
	public FatturaElettronicaBody getFatturaElettronicaBody() {
		return fatturaElettronicaBody;
	}

	public void setFatturaElettronicaBody(FatturaElettronicaBody fatturaElettronicaBody) {
		this.fatturaElettronicaBody = fatturaElettronicaBody;
	}

	

}
