package it.objectmethod.generaXml.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DatiTrasporto")
@XmlType(propOrder = { "datiAnagraficiVettore", "dataOraConsegna" })
public class DatiTrasporto {

	private DatiAnagraficiVettore datiAnagraficiVettore;
	private String dataOraConsegna;
	
	
	@XmlElement(name = "DatiAnagraficiVettore")
	public DatiAnagraficiVettore getDatiAnagraficiVettore() {
		return datiAnagraficiVettore;
	}
	public void setDatiAnagraficiVettore(DatiAnagraficiVettore datiAnagraficiVettore) {
		this.datiAnagraficiVettore = datiAnagraficiVettore;
	}
	
	@XmlElement(name = "DataOraConsegna")
	public String getDataOraConsegna() {
		return dataOraConsegna;
	}
	public void setDataOraConsegna(String dataOraConsegna) {
		this.dataOraConsegna = dataOraConsegna;
	}
	
	
	
}
