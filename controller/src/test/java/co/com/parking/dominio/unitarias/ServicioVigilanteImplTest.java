package co.com.parking.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parking.domain.domain.servicioparqueadero.interfaces.ServicioParqueadero;
import co.com.parking.domain.domain.serviciovehiculo.ServicioMoto;
import co.com.parking.domain.domain.serviciovehiculo.interfaces.ServicioVehiculo;
import co.com.parking.domain.domain.serviciovigilante.ServicioVigilanteImpl;
import co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante;
import co.com.parking.domain.dto.CompositeResponse;
import co.com.parking.persistence.domain.MovimientoVehiculo;
import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;
import co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ServicioVigilanteImplTest {

	ServicioVigilante servicioVigilante;
	CompositeResponse response;
	ServicioVehiculo servicioVehiculo = new ServicioMoto();
	@Test
	public void testSaveVehicule() {
		Vehiculo vehiculo = new Vehiculo(1, new TipoVehiculo(1,"Carro"),"zvn31c", 400);
//		response = new CompositeResponse(CompositeResponse.SUCCESS);
//		ServicioVehiculo servicioVehiculo = mock(ServicioVehiculo.class);
//		ServicioParqueadero servicioParqueadero = mock(ServicioParqueadero.class);
//		ServicioVigilanteRepository servicioVigilanteRepository = mock(ServicioVigilanteRepository.class);
//		
//		Mockito.when(servicioVehiculo.validatePlacasPorFecha((String)Mockito.any(), (Calendar)Mockito.any())).thenReturn(true);	
//		Mockito.when(servicioParqueadero.permitirParqueo((TipoVehiculo)Mockito.any())).thenReturn(true);	
//		Mockito.when(servicioVigilanteRepository.saveVehicule((Vehiculo)Mockito.any())).thenReturn(true);	
//		Mockito.when(servicioVigilanteRepository.saveMovimientoVehicule((MovimientoVehiculo)Mockito.any())).thenReturn(true);
//		
//		servicioVigilante = new ServicioVigilanteImpl(servicioVigilanteRepository);
//		CompositeResponse responseMock= servicioVigilante.saveVehicule(vehiculo);
//		assertEquals(responseMock.getResult(), response.getResult());
	}

	@Test
	public void testOutVehicule() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValorTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindVehicules() {
		fail("Not yet implemented");
	}

}
