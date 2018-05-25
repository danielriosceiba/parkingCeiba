package co.com.parking.domain.domain.serviciovehiculo.abst;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import co.com.parking.domain.domain.serviciovehiculo.interfaces.ServicioVehiculo;

@Service
public abstract class ServicioVehiculoAbst implements ServicioVehiculo{
	private final int INICIO_CADENA = 0;
	private final int FIN_CADENA_PLACA = 1;
	private final String INDICATIVO_PLACA = "A";
	
	public boolean validatePlacasPorFecha(String placa, Calendar calendar) {
		boolean retorno = true;
		 
		if(placa.substring(INICIO_CADENA, FIN_CADENA_PLACA).equalsIgnoreCase(INDICATIVO_PLACA)) {
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				retorno = true;
			}else {
				retorno = false;
			}
		}
		return retorno;
	}
}
