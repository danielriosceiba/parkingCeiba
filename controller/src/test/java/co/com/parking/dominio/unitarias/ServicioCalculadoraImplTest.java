package co.com.parking.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.parking.domain.domain.serviciocalculadora.ServicioCalculadoraImpl;
import co.com.parking.domain.domain.serviciocalculadora.interfaces.ServicioCalculadora;
import co.com.parking.domain.dto.DiaHora;

public class ServicioCalculadoraImplTest {

	ServicioCalculadora servicioCalculadora;

	@Test
	public void testCalcularDiasHoras() {
		int valorHora = 1000;
		int valorDia = 2000;
		servicioCalculadora = new ServicioCalculadoraImpl();
		DiaHora diaHora = new DiaHora(5, 5);
		assertEquals(15000, servicioCalculadora.calcularDiasHoras(diaHora, valorHora, valorDia));
	}

	@Test
	public void testCalcularDiasHorasError() {
		int valorHora = 1000;
		int valorDia = 2000;
		DiaHora diaHora = null;
		servicioCalculadora = new ServicioCalculadoraImpl();
		try {
			servicioCalculadora.calcularDiasHoras(diaHora, valorHora, valorDia);
			fail();
		} catch (Exception e) {
			assertNull(e.getMessage());
		}
	}

} 
