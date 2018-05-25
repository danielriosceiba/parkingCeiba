package co.com.parking.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;

import co.com.parking.domain.domain.serviciovehiculo.ServicioMoto;
import co.com.parking.domain.domain.serviciovehiculo.interfaces.ServicioVehiculo;

public class ServicioMotoTest {

	private final int CLILINDRAJE_SUPERIOR = 600;
	private final int CILINDRAJE_INFERIOR = 400;

	ServicioVehiculo servicioVehiculo;

	@Test
	public void testValidateCilindrajeSuperior() {
		servicioVehiculo = new ServicioMoto(); 
		assertTrue(servicioVehiculo.validateCilindraje(CLILINDRAJE_SUPERIOR));
	}

	@Test
	public void testValidateCilindrajeInferior() {
		servicioVehiculo = new ServicioMoto();
		assertFalse(servicioVehiculo.validateCilindraje(CILINDRAJE_INFERIOR));
	}

	@Test
	public void testValidatePlacasMotoFechaPermitida() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		servicioVehiculo = new ServicioMoto();
		assertTrue(servicioVehiculo.validatePlacasPorFecha("AAA123", calendar));
	}

	@Test
	public void testValidatePlacasMotoFechaNoPermitida() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		servicioVehiculo = new ServicioMoto();
		assertFalse(servicioVehiculo.validatePlacasPorFecha("AAA123", calendar));
	}
	
	@Test
	public void testValidatePlacasSinPrecondicioninicioConA() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		servicioVehiculo = new ServicioMoto();
		assertTrue(servicioVehiculo.validatePlacasPorFecha("BAA123", calendar));
	}

	@Test
	public void testValidatePlacasMotoSinPlaca() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		try {
			servicioVehiculo = new ServicioMoto();
			servicioVehiculo.validatePlacasPorFecha("", calendar);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "String index out of range: 1");
		}
	}
	
	@Test
	public void testValidatePlacasMotoFechaNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		try {
			servicioVehiculo = new ServicioMoto();
			servicioVehiculo.validatePlacasPorFecha("AAAZZZ", null);
			fail();
		} catch (Exception e) {
			assertNull(e.getMessage());
		}
	}

}
