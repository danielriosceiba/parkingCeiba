package co.com.parking.persistence.converter;

import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.entity.TipoVehiculoEntity;

public class TipoVehiculoConverter {

	public TipoVehiculo entityToDomain(TipoVehiculoEntity tipoVehiculoEntity) {
			return new TipoVehiculo(tipoVehiculoEntity.getIdTipoVehiculo(), tipoVehiculoEntity.getNombre());
	}
	
	public TipoVehiculoEntity domainToEntity(TipoVehiculo tipoVehiculo) {
		return new TipoVehiculoEntity(tipoVehiculo.getIdTipoVehiculo(), tipoVehiculo.getNombre());
	}
}

