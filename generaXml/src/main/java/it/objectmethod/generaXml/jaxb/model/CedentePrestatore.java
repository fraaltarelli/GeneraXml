package it.objectmethod.generaXml.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CedentePrestatore")
@XmlType(propOrder = { "datiAnagrafici", "sede" })
public class CedentePrestatore {
	
	private DatiAnagrafici datiAnagrafici;
	private Sede sede;
	
	@XmlElement(name = "DatiAnagrafici")
	public DatiAnagrafici getDatiAnagrafici() {
		return datiAnagrafici;
	}
	public void setDatiAnagrafici(DatiAnagrafici datiAnagrafici) {
		this.datiAnagrafici = datiAnagrafici;
	}
	
	@XmlElement(name = "Sede")
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}

}
