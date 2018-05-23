package co.com.parking.domain.domain.serviciocalendario.interfaces;

import java.util.Date;

import org.springframework.stereotype.Service;

import co.com.parking.domain.dto.DiaHora;

@Service
public interface ServicioCalendario {

	DiaHora obtenerDiasHoras(Date fechaInicio, Date fechaFin);

}
