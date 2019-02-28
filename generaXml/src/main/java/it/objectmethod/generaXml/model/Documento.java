package it.objectmethod.generaXml.model;

public class Documento {

	private Integer id_documento;
	private String num_progressivo;
	private Integer num_documento;
	private String data_documento;
	private String data_prev_consegna;
	
	
	
	public Integer getId_documento() {
		return id_documento;
	}
	public void setId_documento(Integer id_documento) {
		this.id_documento = id_documento;
	}
	public String getNum_progressivo() {
		return num_progressivo;
	}
	public void setNum_progressivo(String num_progressivo) {
		this.num_progressivo = num_progressivo;
	}
	public Integer getNum_documento() {
		return num_documento;
	}
	public void setNum_documento(Integer num_documento) {
		this.num_documento = num_documento;
	}
	public String getData_documento() {
		return data_documento;
	}
	public void setData_documento(String data_documento) {
		this.data_documento = data_documento;
	}
	public String getData_prev_consegna() {
		return data_prev_consegna;
	}
	public void setData_prev_consegna(String data_prev_consegna) {
		this.data_prev_consegna = data_prev_consegna;
	}
	
}
