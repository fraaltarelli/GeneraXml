package it.objectmethod.generaXml.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DatiBeniServizi")
@XmlType(propOrder = { "dettaglioLinee", "datiRiepilogo" })
public class DatiBeniServizi {
	
	private List<DettaglioLinee> dettaglioLinee;
	private DatiRiepilogo datiRiepilogo;
	
	@XmlElementWrapper
	@XmlElement(name = "DettaglioLinee")
	public List<DettaglioLinee> getDettaglioLinee() {
		return dettaglioLinee;
	}
	public void setDettaglioLinee(List<DettaglioLinee> dettaglioLinee) {
		this.dettaglioLinee = dettaglioLinee;
	}
	
	
	@XmlElement(name = "DatiRiepilogo")
	public DatiRiepilogo getDatiRiepilogo() {
		return datiRiepilogo;
	}
	public void setDatiRiepilogo(DatiRiepilogo datiRiepilogo) {
		this.datiRiepilogo = datiRiepilogo;
	}

}
