package co.com.parking.persistence.domain;

import java.io.Serializable;

public class TipoValor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5524217721104906636L;
	private int idTipoValor;
	private Double valor;
	
	public int getIdTipoValor() {
		return idTipoValor;
	}
	public void setIdTipoValor(int idTipoValor) {
		this.idTipoValor = idTipoValor;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
