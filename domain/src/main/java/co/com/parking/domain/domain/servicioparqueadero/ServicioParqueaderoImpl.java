package co.com.parking.domain.domain.servicioparqueadero;

import org.springframework.stereotype.Service;

import co.com.parking.domain.constantes.Constantes;
import co.com.parking.domain.domain.servicioparqueadero.interfaces.ServicioParqueadero;
import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.repository.servicioparqueadero.interfaces.ServicioParqueaderoRepository;

@Service
public class ServicioParqueaderoImpl implements ServicioParqueadero{
	private final int MAX_CANTIDAD_CARROS = 20;
	private final int MAX_CANTIDAD_MOTOS = 10;
	
	ServicioParqueaderoRepository servicioParqueaderoRepository;

	public ServicioParqueaderoImpl(ServicioParqueaderoRepository servicioParqueaderoRepository) {
		this.servicioParqueaderoRepository = servicioParqueaderoRepository;
	}

	public boolean permitirParqueo(TipoVehiculo tipoVehiculo) {
		int cantidad = 0;
		boolean retorno = false;
		
		cantidad = servicioParqueaderoRepository.cantidadVehiculos(tipoVehiculo);
		
		switch (tipoVehiculo.getIdTipoVehiculo()) {
		case Constantes.TipoVehiculo.CARRO:	
			retorno = validarCantidadVehiculosParqueados(MAX_CANTIDAD_CARROS,  cantidad);
			break;
		case Constantes.TipoVehiculo.MOTO:
			retorno = validarCantidadVehiculosParqueados(MAX_CANTIDAD_MOTOS,  cantidad);
			break;
		}
		return retorno;
	}
		
	private boolean validarCantidadVehiculosParqueados(int maximaCantidad, int cantidadParqueadero) {
		boolean retorno = true;
		if(cantidadParqueadero >= maximaCantidad) {
			retorno = false;
		}
		return retorno;
	}
	
}
