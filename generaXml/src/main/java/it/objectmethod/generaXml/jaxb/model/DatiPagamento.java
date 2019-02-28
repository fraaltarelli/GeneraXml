package it.objectmethod.generaXml.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DatiPagamento")
@XmlType(propOrder = { "condizioniPagamento", "dettaglioPagamento" })
public class DatiPagamento {
	
	private String condizioniPagamento;
	private DettaglioPagamento dettaglioPagamento;
	
	
	@XmlElement(name= "CondizioniPagamento")
	public String getCondizioniPagamento() {
		return condizioniPagamento;
	}
	public void setCondizioniPagamento(String condizioniPagamento) {
		this.condizioniPagamento = condizioniPagamento;
	}
	
	@XmlElement(name= "DettaglioPagamento")
	public DettaglioPagamento getDettaglioPagamento() {
		return dettaglioPagamento;
	}
	public void setDettaglioPagamento(DettaglioPagamento dettaglioPagamento) {
		this.dettaglioPagamento = dettaglioPagamento;
	}
	

}
