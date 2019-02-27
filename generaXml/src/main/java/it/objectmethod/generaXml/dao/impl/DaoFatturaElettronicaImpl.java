package it.objectmethod.generaXml.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.objectmethod.generaXml.dao.IDaoFatturaElettronica;
import it.objectmethod.generaXml.model.DatiFatturaDB;
import it.objectmethod.generaXml.model.mapper.DatiFatturaDBMapper;

@Component
public class DaoFatturaElettronicaImpl implements IDaoFatturaElettronica{
	
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public DaoFatturaElettronicaImpl(DataSource dataSource) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	

	@Override
	public List<DatiFatturaDB> generaFattura(Integer idDocumento) {
		
		List<DatiFatturaDB> list = new ArrayList<DatiFatturaDB>();
		String sql ="select d.id_documento, d.num_progressivo, " + 
				"       az.par_iva par_iva_cp, az.cod_fiscale cod_fiscale_cp, az.rag_soc_1 denominazione_cp," + 
				"       a.nazione paese_cc, a.par_iva par_iva_cc, a.cod_fiscale cod_fiscale_cc, a.rag_soc_1 denominazione_cc, a.indirizzo indirizzo_sede_cc, a.cap cap_sede_cc, a.localita localita_sede_cc, a.provincia provincia_sede_cc, a.nazione nazione_sede_cc," + 
				"       pd.descrizione tipo_documento, d.data_documento, d.num_documento, " + 
				"       av.nazione paese_vettore, av.par_iva par_iva_vettore, av.cod_fiscale cod_fiscale_vettore, av.rag_soc_1 denominazione_vettore," + 
				"       d.data_prev_consegna data_ora_consegna, " + 
				"       r.num_riga num_linea_dati_beni_servizi, r.descrizione descrizione_fornitura, r.quantita, r.prezzo, " + 
				"       iva.per_aliquota aliquota_iva, iva.tipo_iva" + 
				"       " + 
				"from documento d join azienda az on d.id_azienda = az.id_azienda " + 
				"join sog_commerciale sc on d.id_sog_commerciale = sc.id_sog_commerciale " + 
				"join anagrafica a on sc.id_anagrafica= a.id_anagrafica " + 
				"join prof_documento pd on d.id_prof_documento = pd.id_prof_documento " + 
				"left join sog_commerciale v on d.id_sog_commerciale_vettore = v.id_sog_commerciale " + 
				"left join anagrafica av on v.id_anagrafica= av.id_anagrafica " + 
				"join riga_documento r on d.id_documento=r.id_documento " + 
				"left join tab_iva iva on r.id_tab_iva = iva.id_tab_iva " + 
				"where d.id_documento= ?";
		
		list = this.jdbcTemplateObject.query(sql, new Object[]{idDocumento}, new DatiFatturaDBMapper());
		
		sql ="prova";
		
		return list;
	}
	
	

}
