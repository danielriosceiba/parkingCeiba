package co.com.parking.domain.domain.serviciocalculadora;

import org.springframework.stereotype.Service;

import co.com.parking.domain.domain.serviciocalculadora.interfaces.ServicioCalculadora;
import co.com.parking.domain.dto.DiaHora;

@Service
public class ServicioCalculadoraImpl implements ServicioCalculadora{
	
	
	public int calcularDiasHoras(DiaHora diaHora, int valorhora, int valorDia) {
		int valorTotal = 0;
		try {
			valorTotal = diaHora.getDias() * valorDia + diaHora.getHoras() *valorhora;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return valorTotal;
	}

}
