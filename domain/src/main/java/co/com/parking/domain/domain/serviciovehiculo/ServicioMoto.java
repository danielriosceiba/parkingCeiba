package co.com.parking.domain.domain.serviciovehiculo;

import java.util.Calendar;

import org.springframework.context.annotation.Primary;

import co.com.parking.domain.domain.serviciovehiculo.abst.ServicioVehiculoAbst;


@Primary
public class ServicioMoto extends ServicioVehiculoAbst{
	private final int VALIDACION_CILINDRAJE_PRECIO = 500;

	public boolean validateCilindraje(int cilindraje) {
		boolean retorno = false;
		if(cilindraje > VALIDACION_CILINDRAJE_PRECIO) {
			retorno = true;
		}
		return retorno;
	}

}
