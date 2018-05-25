package co.com.parking.persistence.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="movimiento_vehiculo")
public class MovimientoVehiculoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_movimiento_vehiculo", unique = true)
	private int idMovimientoVehiculo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_vehiculo")
	private VehiculoEntity vehiculo;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	@Column(name = "parqueado")
	private Boolean parqueado;
	

	public MovimientoVehiculoEntity() {}
	
	public MovimientoVehiculoEntity(VehiculoEntity vehiculo, Date fechaInicio, Date fechaFin,
			Double valorTotal, Boolean parqueado) {
		super();
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

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(VehiculoEntity vehiculo) {
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
	public Boolean getParqueado() {
		return parqueado;
	}
	public void setParqueado(Boolean parqueado) {
		this.parqueado = parqueado;
	}
	
	
}
