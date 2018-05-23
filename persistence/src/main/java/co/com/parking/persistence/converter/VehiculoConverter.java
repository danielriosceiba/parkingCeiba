package co.com.parking.persistence.converter;

import org.springframework.stereotype.Repository;

import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;
import co.com.parking.persistence.entity.TipoVehiculoEntity;
import co.com.parking.persistence.entity.VehiculoEntity;

@Repository
public class VehiculoConverter {

	public Vehiculo entityToDomain(VehiculoEntity vehiculoEntity) {
		return new Vehiculo(vehiculoEntity.getIdVehiculo(),
							new TipoVehiculo(vehiculoEntity.getTipoVehiculo().getIdTipoVehiculo(),
							vehiculoEntity.getTipoVehiculo().getNombre()),
							vehiculoEntity.getPlaca(),
							vehiculoEntity.getCilindraje());
	}
	
	public VehiculoEntity domainToEntity(Vehiculo vehiculo) {
		return new VehiculoEntity(vehiculo.getIdVehiculo(),
								  new TipoVehiculoEntity(vehiculo.getTipoVehiculo().getIdTipoVehiculo(),
								  vehiculo.getTipoVehiculo().getNombre()),
								  vehiculo.getPlaca(),
								  vehiculo.getCilindraje());
	}
}