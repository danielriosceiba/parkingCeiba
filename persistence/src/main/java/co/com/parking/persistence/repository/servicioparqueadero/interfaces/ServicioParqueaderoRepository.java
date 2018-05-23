package co.com.parking.persistence.repository.servicioparqueadero.interfaces;

import co.com.parking.persistence.domain.TipoVehiculo;

public interface ServicioParqueaderoRepository {

	public Integer cantidadVehiculos(TipoVehiculo tipoVehiculo);
}
