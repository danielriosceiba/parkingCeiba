package co.com.parking.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;

import co.com.parking.domain.domain.serviciovehiculo.ServicioCarro;
import co.com.parking.domain.domain.serviciovehiculo.interfaces.ServicioVehiculo;

public class ServicioCarroTest {
	
	ServicioVehiculo servicioVehiculo;

	@Test
	public void testValidateCilindraje() {
		assertTrue(true);
	}

	@Test
	public void testValidatePlacasCarroFechaPermitida() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 

		servicioVehiculo = new ServicioCarro();
		assertTrue(servicioVehiculo.validatePlacasPorFecha("AAA123", calendar));
	}

	@Test
	public void testValidatePlacasCarroFechaNoPermitida() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		servicioVehiculo = new ServicioCarro();
		assertFalse(servicioVehiculo.validatePlacasPorFecha("AAA123", calendar));
	}
	
	@Test
	public void testValidatePlacasCarroSinPrecondicioninicioConA() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		servicioVehiculo = new ServicioCarro();
		assertTrue(servicioVehiculo.validatePlacasPorFecha("BAA123", calendar));
	}

	@Test
	public void testValidatePlacasCarroSinPlaca() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		try {
			servicioVehiculo = new ServicioCarro();
			servicioVehiculo.validatePlacasPorFecha("", calendar);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "String index out of range: 1");
		} 
	}
	
	@Test
	public void testValidatePlacasCarroFechaNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		try {
			servicioVehiculo = new ServicioCarro();
			servicioVehiculo.validatePlacasPorFecha("AAAZZZ", null);
			fail();
		} catch (Exception e) {
			assertNull(e.getMessage());
		}
	}

}
