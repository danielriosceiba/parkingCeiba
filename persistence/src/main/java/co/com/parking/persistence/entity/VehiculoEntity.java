package co.com.parking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")
public class VehiculoEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vehiculo", unique = true)
	private int idVehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_vehiculo")
	private TipoVehiculoEntity tipoVehiculo;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "cilindraje")
	private int cilindraje;
	
	public VehiculoEntity() {}
	
	
	public VehiculoEntity(int idVehiculo, TipoVehiculoEntity tipoVehiculo, String placa, int cilindraje) {
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
	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
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
