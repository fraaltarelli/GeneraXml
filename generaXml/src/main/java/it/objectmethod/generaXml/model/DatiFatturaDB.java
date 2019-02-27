package it.objectmethod.generaXml.model;

public class DatiFatturaDB {
	
	Documento documento;
	Azienda azienda;
	Anagrafica anagraficaCC;
	Anagrafica anagraficaVettore;
	ProfDocumento profDocumento;
	RigaDocumento rigaDocumento;
	Iva tabIva;
	
	
	
	public Anagrafica getAnagraficaCC() {
		return anagraficaCC;
	}
	public void setAnagraficaCC(Anagrafica anagraficaCC) {
		this.anagraficaCC = anagraficaCC;
	}
	public Anagrafica getAnagraficaVettore() {
		return anagraficaVettore;
	}
	public void setAnagraficaVettore(Anagrafica anagraficaVettore) {
		this.anagraficaVettore = anagraficaVettore;
	}
	public ProfDocumento getProfDocumento() {
		return profDocumento;
	}
	public void setProfDocumento(ProfDocumento profDocumento) {
		this.profDocumento = profDocumento;
	}
	public RigaDocumento getRigaDocumento() {
		return rigaDocumento;
	}
	public void setRigaDocumento(RigaDocumento rigaDocumento) {
		this.rigaDocumento = rigaDocumento;
	}
	public Iva getTabIva() {
		return tabIva;
	}
	public void setTabIva(Iva tabIva) {
		this.tabIva = tabIva;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	public Azienda getAzienda() {
		return azienda;
	}
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}
	


}
