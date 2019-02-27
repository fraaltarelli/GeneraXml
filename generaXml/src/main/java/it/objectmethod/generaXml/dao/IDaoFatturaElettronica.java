package it.objectmethod.generaXml.dao;

import java.util.List;

import it.objectmethod.generaXml.model.DatiFatturaDB;



public interface IDaoFatturaElettronica {

	public List<DatiFatturaDB> generaFattura(Integer idDocumento);
}
