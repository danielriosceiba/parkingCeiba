package co.com.parking.persistence.domain;

import java.io.Serializable;

public class Vehiculo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3994292060686859347L;
	private int idVehiculo;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private int cilindraje;
	
	public Vehiculo(){}
	
	public Vehiculo(int idVehiculo, TipoVehiculo tipoVehiculo, String placa, int cilindraje) {
		super();
		this.idVehiculo = idVehiculo;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public TipoVehiculo getTipoVehiculo() {
		if(tipoVehiculo == null) {
			tipoVehiculo = new TipoVehiculo();
		}
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
}
