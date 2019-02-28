package it.objectmethod.generaXml.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "FatturaElettronicaBody")
@XmlType(propOrder = { "datiGenerali", "datiBeniServizi", "datiPagamento" })
public class FatturaElettronicaBody {

	private DatiGenerali datiGenerali;
	private DatiBeniServizi datiBeniServizi;
	private DatiPagamento datiPagamento;
	
	
	@XmlElement(name= "DatiPagamento")
	public DatiPagamento getDatiPagamento() {
		return datiPagamento;
	}

	public void setDatiPagamento(DatiPagamento datiPagamento) {
		this.datiPagamento = datiPagamento;
	}

	@XmlElement(name= "DatiBeniServizi")
	public DatiBeniServizi getDatiBeniServizi() {
		return datiBeniServizi;
	}

	public void setDatiBeniServizi(DatiBeniServizi datiBeniServizi) {
		this.datiBeniServizi = datiBeniServizi;
	}

	@XmlElement(name= "DatiGenerali")
	public DatiGenerali getDatiGenerali() {
		return datiGenerali;
	}

	public void setDatiGenerali(DatiGenerali datiGenerali) {
		this.datiGenerali = datiGenerali;
	}
	
}
