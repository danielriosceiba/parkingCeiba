package co.com.parking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_vehiculo")
public class TipoVehiculoEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_vehiculo", unique = true)
	private int idTipoVehiculo;	
	@Column(name = "nombre")
	private String nombre;

	public TipoVehiculoEntity() {}
	
	public TipoVehiculoEntity(int idTipoVehiculo, String nombre) {
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
