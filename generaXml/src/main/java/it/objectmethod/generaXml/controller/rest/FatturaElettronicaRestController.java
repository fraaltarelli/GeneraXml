package it.objectmethod.generaXml.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.generaXml.dao.IDaoFatturaElettronica;
import it.objectmethod.generaXml.jaxb.FatturaElettronicaMain;
import it.objectmethod.generaXml.model.DatiFatturaDB;

@RestController
@RequestMapping("/api")
public class FatturaElettronicaRestController {
	
	@Autowired 
	IDaoFatturaElettronica daoFatturaElettronica;
	
	@Autowired
	FatturaElettronicaMain fatturaMain;
	
	
	@GetMapping("/fattura/{idDocumento}")
	public List<DatiFatturaDB> prova(@PathVariable("idDocumento") Integer idDocumento) {
		List<DatiFatturaDB> list = daoFatturaElettronica.generaFattura(idDocumento);
		fatturaMain.marshalFattura(list);		
		return list;
	}

}
