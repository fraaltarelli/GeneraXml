package it.objectmethod.generaXml.model;

public class RigaDocumento {
	
	private Integer num_riga;
	private String descrizione;
	private Double quantita;
	private Double prezzo;
	
	
	
	public Integer getNum_riga() {
		return num_riga;
	}
	public void setNum_riga(Integer num_riga) {
		this.num_riga = num_riga;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Double getQuantita() {
		return quantita;
	}
	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

}
