package co.com.parking.domain.domain.serviciovehiculo.interfaces;

import java.util.Calendar;

public interface ServicioVehiculo {

	boolean validateCilindraje(int cilindraje);

	boolean validatePlacasPorFecha(String placa, Calendar calendar);

}
