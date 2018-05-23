package co.com.parking.domain.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import co.com.parking.domain.domain.servicioparqueadero.ServicioParqueaderoImpl;
import co.com.parking.domain.domain.servicioparqueadero.interfaces.ServicioParqueadero;
import co.com.parking.domain.domain.serviciovigilante.ServicioVigilanteImpl;
import co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante;
import co.com.parking.persistence.repository.servicioparqueadero.interfaces.ServicioParqueaderoRepository;
import co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository;

@Configuration
public class DomainConfig {

	@Qualifier
    public ServicioVigilante createServicioVigilante(ServicioVigilanteRepository servicioVehiculoRepository) {
	    return new ServicioVigilanteImpl(servicioVehiculoRepository);
    }
	
	public ServicioParqueadero createServicioParqueadero(ServicioParqueaderoRepository servicioParqueaderoRepository) {
		return new ServicioParqueaderoImpl(servicioParqueaderoRepository);
	}
    
}
