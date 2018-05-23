package co.com.parking.persistence.repository.serviciovigilante.interfaces;

import java.util.List;

import co.com.parking.persistence.domain.MovimientoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;

public interface ServicioVigilanteRepository {

	public boolean saveVehicule(Vehiculo vehiculo);
	
	public boolean saveMovimientoVehicule(MovimientoVehiculo movimientoVehiculo);
	
	public List<MovimientoVehiculo> findVehicules();
	
	public MovimientoVehiculo findMovimientoVehiculoByVehiculo(Vehiculo vehiculo);
	
	public boolean updateVehicule(MovimientoVehiculo movimientoVehiculo);
}
