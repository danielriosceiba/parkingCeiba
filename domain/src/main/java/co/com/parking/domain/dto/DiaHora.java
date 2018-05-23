package co.com.parking.domain.dto;

import java.io.Serializable;

public class DiaHora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399876037960500609L;
	private int horas;
	private int dias;
	
	public DiaHora(int horas, int dias) {
		super();
		this.horas = horas;
		this.dias = dias;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
}
