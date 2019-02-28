package it.objectmethod.generaXml.jaxb;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import it.objectmethod.generaXml.jaxb.model.Anagrafica;
import it.objectmethod.generaXml.jaxb.model.CedentePrestatore;
import it.objectmethod.generaXml.jaxb.model.CessionarioCommittente;
import it.objectmethod.generaXml.jaxb.model.DatiAnagrafici;
import it.objectmethod.generaXml.jaxb.model.DatiAnagraficiVettore;
import it.objectmethod.generaXml.jaxb.model.DatiBeniServizi;
import it.objectmethod.generaXml.jaxb.model.DatiGenerali;
import it.objectmethod.generaXml.jaxb.model.DatiGeneraliDocumento;
import it.objectmethod.generaXml.jaxb.model.DatiRiepilogo;
import it.objectmethod.generaXml.jaxb.model.DatiTrasmissione;
import it.objectmethod.generaXml.jaxb.model.DatiTrasporto;
import it.objectmethod.generaXml.jaxb.model.DettaglioLinee;
import it.objectmethod.generaXml.jaxb.model.FatturaElettronica;
import it.objectmethod.generaXml.jaxb.model.FatturaElettronicaBody;
import it.objectmethod.generaXml.jaxb.model.FatturaElettronicaHeader;
import it.objectmethod.generaXml.jaxb.model.IdFiscaleIva;
import it.objectmethod.generaXml.jaxb.model.Sede;
import it.objectmethod.generaXml.model.DatiFatturaDB;


@Component
public class FatturaElettronicaMain {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FatturaElettronicaMain.class);
	
	public void marshalFattura(List<DatiFatturaDB> list) {
		
		FatturaElettronica fattura = new FatturaElettronica();
		FatturaElettronicaHeader fatturaHeader = new FatturaElettronicaHeader();
		FatturaElettronicaBody fatturaBody = new FatturaElettronicaBody();
		DatiFatturaDB dati = list.get(0);
		
		
		//Fattura Elettronica Header
		
		//Dati Trasmissione
		DatiTrasmissione datiTrasmissione = new DatiTrasmissione();
		datiTrasmissione.setProgressivoInvio(dati.getDocumento().getNum_progressivo());
		fatturaHeader.setDatiTrasmissione(datiTrasmissione);
		
		//CedentePrestatore
		CedentePrestatore cp = new CedentePrestatore();
		DatiAnagrafici datiAnagraficiCP = new DatiAnagrafici();
		IdFiscaleIva ivaCP = new IdFiscaleIva();
		ivaCP.setIdCodice(dati.getAzienda().getPar_iva());	
		datiAnagraficiCP.setIdFiscaleIva(ivaCP);
		datiAnagraficiCP.setCodiceFiscale(dati.getAzienda().getCod_fiscale());
		
		Anagrafica anagraficaCP = new Anagrafica();
		anagraficaCP.setDenominazione(dati.getAzienda().getRag_soc_1());
		datiAnagraficiCP.setAnagrafica(anagraficaCP);
		
		cp.setDatiAnagrafici(datiAnagraficiCP);
		fatturaHeader.setCedentePrestatore(cp);
		
		//Cessionario Committente
		CessionarioCommittente cc = new CessionarioCommittente();
		DatiAnagrafici datiAnagraficiCC = new DatiAnagrafici();
		IdFiscaleIva ivaCC = new IdFiscaleIva();
		ivaCC.setIdPaese(dati.getAnagraficaCC().getNazione());
		ivaCC.setIdCodice(dati.getAnagraficaCC().getPar_iva());
		datiAnagraficiCC.setIdFiscaleIva(ivaCC);
		datiAnagraficiCC.setCodiceFiscale(dati.getAnagraficaCC().getCod_fiscale());
		
		Anagrafica anagraficaCC = new Anagrafica();
		anagraficaCC.setDenominazione(dati.getAnagraficaCC().getRag_soc_1());
		datiAnagraficiCC.setAnagrafica(anagraficaCC);
		
		cc.setDatiAnagrafici(datiAnagraficiCC);
		
		Sede sedeCC = new Sede();
		sedeCC.setIndirizzo(dati.getAnagraficaCC().getIndirizzo());
		sedeCC.setCap(dati.getAnagraficaCC().getCap());
		sedeCC.setComune(dati.getAnagraficaCC().getLocalita());
		sedeCC.setProvincia(dati.getAnagraficaCC().getProvincia());
		cc.setSede(sedeCC);
		
		fatturaHeader.setCessionarioCommittente(cc);
		
		fattura.setFatturaElettronicaHeader(fatturaHeader);
		
	    
	    // Fattura Elettronica Body
		
		//Dati Generali
		DatiGenerali datiGenerali = new DatiGenerali();
	    DatiGeneraliDocumento datiGeneraliDocumento = new DatiGeneraliDocumento();
	    datiGeneraliDocumento.setTipoDocumento(dati.getProfDocumento().getDescrizione());
	    datiGeneraliDocumento.setData(dati.getDocumento().getData_documento());
	    datiGeneraliDocumento.setNumero(dati.getDocumento().getNum_documento());
	    datiGenerali.setDatiGeneraliDocumento(datiGeneraliDocumento);
	    
	    DatiTrasporto datiTrasporto = new DatiTrasporto();
	    DatiAnagraficiVettore datiAnagraficiVettore = new DatiAnagraficiVettore();
	    IdFiscaleIva ivaVettore = new IdFiscaleIva();
	    ivaVettore.setIdPaese(dati.getAnagraficaVettore().getNazione());
	    ivaVettore.setIdCodice(dati.getAnagraficaVettore().getPar_iva());
	    datiAnagraficiVettore.setIdFiscaleIva(ivaVettore);
	    datiAnagraficiVettore.setCodiceFiscale(dati.getAnagraficaVettore().getCod_fiscale());
	    Anagrafica anagraficaVettore = new Anagrafica();
	    anagraficaVettore.setDenominazione(dati.getAnagraficaVettore().getRag_soc_1());
		datiTrasporto.setDataOraConsegna(dati.getDocumento().getData_prev_consegna());
		datiGenerali.setDatiTrasporto(datiTrasporto);
		
		fatturaBody.setDatiGenerali(datiGenerali);
		
		// Dati Beni Servizi
		DatiBeniServizi datiBeniServizi = new DatiBeniServizi();
		List<DettaglioLinee> listaDettaglioLinee = new ArrayList<DettaglioLinee>();
		
		for(DatiFatturaDB datiDettaglioLinee : list) {
			DettaglioLinee dettaglioLinee = new DettaglioLinee();
			dettaglioLinee.setNumeroLinea(datiDettaglioLinee.getRigaDocumento().getNum_riga());
			dettaglioLinee.setDescrizione(datiDettaglioLinee.getRigaDocumento().getDescrizione());
			Double quantita = datiDettaglioLinee.getRigaDocumento().getQuantita();
			Double prezzoUnitario = datiDettaglioLinee.getRigaDocumento().getPrezzo();
			dettaglioLinee.setQuantita(quantita);
			dettaglioLinee.setPrezzoUnitario(prezzoUnitario);
			dettaglioLinee.setPrezzoTotale(quantita*prezzoUnitario);
			listaDettaglioLinee.add(dettaglioLinee);
		}
		
		datiBeniServizi.setDettaglioLinee(listaDettaglioLinee);
		
		DatiRiepilogo datiRiepilogo = new DatiRiepilogo();
		datiRiepilogo.setAliquotaIVA(dati.getTabIva().getPer_aliquota());
		datiRiepilogo.setEsigibilitaIVA(dati.getTabIva().getTipo_iva());
		datiBeniServizi.setDatiRiepilogo(datiRiepilogo);
		
		fatturaBody.setDatiBeniServizi(datiBeniServizi);
		
		
		fattura.setFatturaElettronicaHeader(fatturaHeader);
		fattura.setFatturaElettronicaBody(fatturaBody);
		
		
		try{
			
		    JAXBContext jContext = JAXBContext.newInstance(FatturaElettronica.class);
		    Marshaller marshallObj = jContext.createMarshaller();
		    marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    marshallObj.marshal(fattura, new FileOutputStream("C:\\Users\\Francesco Altarelli\\Documents\\output folder\\prova.xml"));
		
		} catch(Exception e) {
			LOGGER.error("errore nel marshal fattura", e);
		}
		
	}
	

}
