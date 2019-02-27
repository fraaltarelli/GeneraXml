package it.objectmethod.generaXml.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "IdFiscaleIva")

public class IdFiscaleIva {

	private String idPaese;
	private String idCodice;
	
	@XmlElement(name = "IdPaese")
	public String getIdPaese() {
		return idPaese;
	}
	public void setIdPaese(String idPaese) {
		this.idPaese = idPaese;
	}
	
	@XmlElement(name = "IdCodice")
	public String getIdCodice() {
		return idCodice;
	}
	public void setIdCodice(String idCodice) {
		this.idCodice = idCodice;
	}
}
