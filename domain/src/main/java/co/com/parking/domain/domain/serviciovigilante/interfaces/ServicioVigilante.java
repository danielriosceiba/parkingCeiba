package co.com.parking.domain.domain.serviciovigilante.interfaces;

import java.util.List;

import co.com.parking.domain.dto.CompositeResponse;
import co.com.parking.domain.dto.DiaHora;
import co.com.parking.persistence.domain.MovimientoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;

public interface ServicioVigilante {
	
	CompositeResponse saveVehicule(Vehiculo vehiculo);

	int outVehicule(Vehiculo vehiculo);
	
	public int getValorTotal(Vehiculo vehiculo, DiaHora diaHora);
	
	List<MovimientoVehiculo> findVehicules();

}
