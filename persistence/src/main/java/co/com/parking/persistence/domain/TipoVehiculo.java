package co.com.parking.persistence.domain;

import java.io.Serializable;

public class TipoVehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8665664806880153297L;
	private int idTipoVehiculo;
	private String nombre;
	
	public TipoVehiculo() {}
	
	public TipoVehiculo(int idTipoVehiculo, String nombre) {
		super();
		this.idTipoVehiculo = idTipoVehiculo;
		this.nombre = nombre;
	}
	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}
	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
