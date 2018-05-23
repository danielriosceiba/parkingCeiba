package co.com.parking.domain.domain.serviciovehiculo.abst;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import co.com.parking.domain.domain.serviciovehiculo.interfaces.ServicioVehiculo;

@Service
public abstract class ServicioVehiculoAbst implements ServicioVehiculo{
	private final int INICIO_CADENA = 0;
	private final int FIN_CADENA_PLACA = 1;
	private final String INDICATIVO_PLACA = "A";
	
	public boolean validatePlacas(String placa) {
		boolean retorno = true;
		Calendar calendar = Calendar.getInstance();
		 
		if(placa.substring(INICIO_CADENA, FIN_CADENA_PLACA).equalsIgnoreCase(INDICATIVO_PLACA)) {
			if(calendar.DAY_OF_WEEK == Calendar.SUNDAY || calendar.DAY_OF_WEEK == Calendar.MONDAY) {
				retorno = true;
			}else {
				retorno = false;
			}
		}
		return retorno;
	}
}
