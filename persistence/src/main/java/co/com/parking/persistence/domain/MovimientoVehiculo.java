package co.com.parking.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class MovimientoVehiculo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5969824023605389580L;
	private int idMovimientoVehiculo;
	private Vehiculo vehiculo;
	private Date fechaInicio;
	private Date fechaFin;
	private Double valorTotal;
	private boolean parqueado;
	
	public MovimientoVehiculo() {}
	
	public MovimientoVehiculo(int idMovimientoVehiculo, Vehiculo vehiculo, Date fechaInicio, Date fechaFin,
			Double valorTotal, boolean parqueado) {
		super();
		this.idMovimientoVehiculo = idMovimientoVehiculo;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorTotal = valorTotal;
		this.parqueado = parqueado;
	}
	public int getIdMovimientoVehiculo() {
		return idMovimientoVehiculo;
	}
	public void setIdMovimientoVehiculo(int idMovimientoVehiculo) {
		this.idMovimientoVehiculo = idMovimientoVehiculo;
	}
	public Vehiculo getVehiculo() {
		if(vehiculo == null) {
			vehiculo = new Vehiculo();
		}
		
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public boolean isParqueado() {
		return parqueado;
	}
	public void setParqueado(boolean parqueado) {
		this.parqueado = parqueado;
	}
	
}
