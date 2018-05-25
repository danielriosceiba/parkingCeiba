package co.com.parking.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;

import co.com.parking.domain.domain.serviciocalendario.ServicioCalendarioImpl;
import co.com.parking.domain.domain.serviciocalendario.interfaces.ServicioCalendario;
import co.com.parking.domain.dto.DiaHora;

public class ServicioCalendarioImplTest {
	
	ServicioCalendario servicioCalendario;

	@Test
	public void testObtenerDiasHoras() {
		servicioCalendario = new ServicioCalendarioImpl();
		try {
			servicioCalendario.obtenerDiasHoras(null, null);
			fail("");
		} catch (Exception e) {
			assertNull(e.getMessage());
		}

	}

	@Test
	public void testObtenerDiasHorasSumarMinuto() {
		servicioCalendario = new ServicioCalendarioImpl();
		
		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.add(Calendar.MINUTE, 1);
		DiaHora diaHora = servicioCalendario.obtenerDiasHoras(calendarInicio.getTime(), calendarFin.getTime());
		assertEquals(diaHora.getHoras(), 1);
	}
	
	@Test
	public void testObtenerDiasHorasSumarHora() {
		servicioCalendario = new ServicioCalendarioImpl();
		
		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.add(Calendar.HOUR, 1);
		DiaHora diaHora = servicioCalendario.obtenerDiasHoras(calendarInicio.getTime(), calendarFin.getTime());
		assertEquals(diaHora.getHoras(), 1);
	}
	
	@Test
	public void testObtenerDiasHorasSumarHorasParaUnDia() {
		servicioCalendario = new ServicioCalendarioImpl(); 
		
		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.add(Calendar.HOUR, 10);
		DiaHora diaHora = servicioCalendario.obtenerDiasHoras(calendarInicio.getTime(), calendarFin.getTime());
		assertEquals(diaHora.getDias(), 1);
	}
}
