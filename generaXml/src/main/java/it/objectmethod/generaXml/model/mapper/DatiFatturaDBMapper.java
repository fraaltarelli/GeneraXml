package it.objectmethod.generaXml.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.generaXml.model.Anagrafica;
import it.objectmethod.generaXml.model.Azienda;
import it.objectmethod.generaXml.model.DatiFatturaDB;
import it.objectmethod.generaXml.model.Documento;
import it.objectmethod.generaXml.model.Iva;
import it.objectmethod.generaXml.model.ProfDocumento;
import it.objectmethod.generaXml.model.RigaDocumento;

public class DatiFatturaDBMapper  implements RowMapper<DatiFatturaDB>{

	@Override
	public DatiFatturaDB mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DatiFatturaDB dati = new DatiFatturaDB();
		Documento documento = new Documento();
		Azienda azienda = new Azienda();
		Anagrafica anagraficaCC = new Anagrafica();
		Anagrafica anagraficaVettore = new Anagrafica();
		ProfDocumento profDocumento = new ProfDocumento();
		RigaDocumento rigaDocumento = new RigaDocumento();
		Iva iva = new Iva();
		
		
		documento.setId_documento(rs.getInt("id_documento"));
		documento.setNum_progressivo(rs.getString("num_progressivo"));
		azienda.setPar_iva(rs.getString("par_iva_cp"));
		azienda.setCod_fiscale(rs.getString("cod_fiscale_cp"));
		azienda.setRag_soc_1(rs.getString("denominazione_cp"));
		anagraficaCC.setNazione(rs.getString("paese_cc"));
		anagraficaCC.setPar_iva(rs.getString("par_iva_cc"));
		anagraficaCC.setCod_fiscale(rs.getString("cod_fiscale_cc"));
		anagraficaCC.setRag_soc_1(rs.getString("denominazione_cc"));
		anagraficaCC.setIndirizzo(rs.getString("indirizzo_sede_cc"));
		anagraficaCC.setCap(rs.getString("cap_sede_cc"));
		anagraficaCC.setLocalita(rs.getString("localita_sede_cc"));
		anagraficaCC.setProvincia(rs.getString("provincia_sede_cc"));
		profDocumento.setDescrizione(rs.getString("tipo_documento"));
		documento.setData_documento(rs.getString("data_documento"));
		documento.setNum_documento(rs.getInt("num_documento"));
		anagraficaVettore.setNazione(rs.getString("paese_vettore"));
		anagraficaVettore.setPar_iva(rs.getString("par_iva_vettore"));
		anagraficaVettore.setCod_fiscale(rs.getString("cod_fiscale_vettore"));
		anagraficaVettore.setRag_soc_1(rs.getString("denominazione_vettore"));
		documento.setData_prev_consegna(rs.getString("data_ora_consegna"));
		rigaDocumento.setNum_riga(rs.getInt("num_linea_dati_beni_servizi"));
		rigaDocumento.setDescrizione(rs.getString("descrizione_fornitura"));
		rigaDocumento.setQuantita(rs.getDouble("quantita"));
		rigaDocumento.setPrezzo(rs.getDouble("prezzo"));
		iva.setPer_aliquota(rs.getDouble("aliquota_iva"));
		iva.setTipo_iva(rs.getString("tipo_iva"));
		
		
		dati.setDocumento(documento);
		dati.setAzienda(azienda);
		dati.setAnagraficaCC(anagraficaCC);
		dati.setProfDocumento(profDocumento);
		dati.setAnagraficaVettore(anagraficaVettore);
		dati.setRigaDocumento(rigaDocumento);
		dati.setTabIva(iva);
		
		return dati;
		
	}

}
