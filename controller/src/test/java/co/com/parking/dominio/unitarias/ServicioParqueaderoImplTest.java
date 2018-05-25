package co.com.parking.dominio.unitarias;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parking.domain.domain.servicioparqueadero.ServicioParqueaderoImpl;
import co.com.parking.domain.domain.servicioparqueadero.interfaces.ServicioParqueadero;
import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.repository.servicioparqueadero.interfaces.ServicioParqueaderoRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ServicioParqueaderoImplTest {
	ServicioParqueadero servicioParqueadero;
	TipoVehiculo tipoVehiculo;
	 

	@Test
	public void testPermitirParqueo() {
		tipoVehiculo = new TipoVehiculo(); 
		tipoVehiculo.setIdTipoVehiculo(1);
		tipoVehiculo.setNombre("carro");
		
		ServicioParqueaderoRepository servicioParqueaderoRepository = mock(ServicioParqueaderoRepository.class);
		Mockito.when(servicioParqueaderoRepository.cantidadVehiculos((TipoVehiculo)Mockito.any())).thenReturn(19);	
		servicioParqueadero = new ServicioParqueaderoImpl(servicioParqueaderoRepository);
		assertTrue(servicioParqueadero.permitirParqueo(tipoVehiculo));
	} 
	
	@Test
	public void testNoPermitirParqueo() {
		tipoVehiculo = new TipoVehiculo();
		tipoVehiculo.setIdTipoVehiculo(1);
		tipoVehiculo.setNombre("carro");
		
		ServicioParqueaderoRepository servicioParqueaderoRepository = mock(ServicioParqueaderoRepository.class);
		Mockito.when(servicioParqueaderoRepository.cantidadVehiculos((TipoVehiculo)Mockito.any())).thenReturn(20);	
		servicioParqueadero = new ServicioParqueaderoImpl(servicioParqueaderoRepository);
		assertFalse(servicioParqueadero.permitirParqueo(tipoVehiculo));
	}
}
