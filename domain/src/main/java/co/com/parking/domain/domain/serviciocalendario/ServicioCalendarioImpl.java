package co.com.parking.domain.domain.serviciocalendario;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import co.com.parking.domain.domain.serviciocalendario.interfaces.ServicioCalendario;
import co.com.parking.domain.dto.DiaHora;

@Service
public class ServicioCalendarioImpl implements ServicioCalendario {
	private final int MINUTOS_HORA = 60;
	private final int HORAS_DIA_PARQUEADERO = 9;
	private final int HORAS_DIA = 24;
	private final int REDONDEO_HORA = 1;
	private final int REDONDEO_DIA = 1;

	public DiaHora obtenerDiasHoras(Date fechaInicio, Date fechaFin) {
		int horasRestadas;
		int diasACobrar = 0;
		int horasACobrar = 0;

		long resultado = fechaFin.getTime() - fechaInicio.getTime();
		int minutos = (int) TimeUnit.MINUTES.convert(resultado, TimeUnit.MILLISECONDS);

		if (minutos % MINUTOS_HORA > 0) {
			horasRestadas = (int) TimeUnit.HOURS.convert(minutos, TimeUnit.MINUTES) + REDONDEO_HORA;
		} else {
			horasRestadas = (int) TimeUnit.HOURS.convert(minutos, TimeUnit.MINUTES);
		}

		if (horasRestadas > HORAS_DIA_PARQUEADERO && horasRestadas < HORAS_DIA) {
			diasACobrar = REDONDEO_DIA;
		} else if (horasRestadas > HORAS_DIA) {
			diasACobrar = horasRestadas / HORAS_DIA;
			horasACobrar = horasRestadas % HORAS_DIA;
			if (horasACobrar > HORAS_DIA_PARQUEADERO) {
				diasACobrar = diasACobrar + REDONDEO_DIA;
				horasACobrar = 0;
			}
		}else {
			horasACobrar = horasRestadas;
		}

		return new DiaHora(horasACobrar, diasACobrar);
	}

	public static void main(String[] args) {

		// Establecemos la fecha que deseamos en un Calendario
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		// Desplegamos la fecha
		Date tempDate = cal.getTime();
		System.out.println("Fecha actual: " + tempDate);

		// Le cambiamos la hora y minutos
		cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 2);
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 5);
		tempDate = cal.getTime();
		System.out.println("Hora modificada: " + tempDate);

		// Le cambiamos el mes
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		System.out.println("Fecha modificada: " + cal.getTime());

		Calendar calendar1 = Calendar.getInstance();
		cal.setTime(new Date());

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 33);
		System.out.println(20 % 60);
		System.out.println(121 % 60);
		System.out.println(20 / 60);
		DiaHora diaHora = calcularDiasHoras(calendar1.getTime(), calendar2.getTime());
		
		cobrar(diaHora, 1000, 8000);

	}

	private static int cobrar(DiaHora diaHora, int valorhora, int valorDia) {
		int valorTotal = diaHora.getDias() * valorDia + diaHora.getHoras() *valorhora;
		return valorTotal;
	}

	private static DiaHora calcularDiasHoras(Date fecha1, Date fecha2) {
		int horas;
		int dias = 0;
		int horasACobrar = 0;
		long resultado = fecha2.getTime() - fecha1.getTime();
		int minutos = (int) TimeUnit.MINUTES.convert(resultado, TimeUnit.MILLISECONDS);

		if (minutos % 60 > 0) {
			horas = (int) TimeUnit.HOURS.convert(minutos, TimeUnit.MINUTES) + 1;
		} else {
			horas = (int) TimeUnit.HOURS.convert(minutos, TimeUnit.MINUTES);
		}

		if (horas > 9 && horas < 24) {
			dias = 1;
		} else if (horas > 24) {
			dias = horas / 24;
			horasACobrar = horas % 24;
			if (horasACobrar > 9) {
				dias = dias + 1;
				horasACobrar = 0;
			}
		}

		return new DiaHora(horasACobrar, dias);
	}

}
