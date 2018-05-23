package co.com.parking.persistence.converter;

import org.springframework.stereotype.Repository;

import co.com.parking.persistence.domain.MovimientoVehiculo;
import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;
import co.com.parking.persistence.entity.MovimientoVehiculoEntity;
import co.com.parking.persistence.entity.TipoVehiculoEntity;
import co.com.parking.persistence.entity.VehiculoEntity;

@Repository
public class MovimientoVehiculoConverter {

	public MovimientoVehiculo entityToDomain(MovimientoVehiculoEntity movimientoVehiculoEntity) {
		return new MovimientoVehiculo(movimientoVehiculoEntity.getIdMovimientoVehiculo(),
									  new Vehiculo(movimientoVehiculoEntity.getVehiculo().getIdVehiculo(),
											  	   new TipoVehiculo(movimientoVehiculoEntity.getVehiculo().getTipoVehiculo().getIdTipoVehiculo(),
											  			            movimientoVehiculoEntity.getVehiculo().getTipoVehiculo().getNombre()),
											  	   movimientoVehiculoEntity.getVehiculo().getPlaca(),
											  	   movimientoVehiculoEntity.getVehiculo().getCilindraje()),
									  movimientoVehiculoEntity.getFechaInicio(),
									  movimientoVehiculoEntity.getFechaFin(),
									  movimientoVehiculoEntity.getValorTotal(),
									  movimientoVehiculoEntity.getParqueado());
	}
	
	public MovimientoVehiculoEntity domainToEntity(MovimientoVehiculo movimientoVehiculo) {
		return new MovimientoVehiculoEntity(new VehiculoEntity(movimientoVehiculo.getVehiculo().getIdVehiculo(), 
														       new TipoVehiculoEntity(movimientoVehiculo.getVehiculo().getTipoVehiculo().getIdTipoVehiculo(), 
														    		   				  movimientoVehiculo.getVehiculo().getTipoVehiculo().getNombre()), 
											movimientoVehiculo.getVehiculo().getPlaca(),
											 movimientoVehiculo.getVehiculo().getCilindraje()),
											movimientoVehiculo.getFechaInicio(),
											movimientoVehiculo.getFechaFin(),
											movimientoVehiculo.getValorTotal(),
											movimientoVehiculo.isParqueado());
	}
}
