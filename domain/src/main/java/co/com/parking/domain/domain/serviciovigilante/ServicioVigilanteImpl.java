package co.com.parking.domain.domain.serviciovigilante;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.domain.constantes.Constantes.MensajesRespuesta;
import co.com.parking.domain.constantes.Constantes.TablaPrecios;
import co.com.parking.domain.constantes.Constantes.TipoVehiculo;
import co.com.parking.domain.domain.serviciocalculadora.interfaces.ServicioCalculadora;
import co.com.parking.domain.domain.serviciocalendario.interfaces.ServicioCalendario;
import co.com.parking.domain.domain.servicioparqueadero.interfaces.ServicioParqueadero;
import co.com.parking.domain.domain.serviciovehiculo.ServicioMoto;
import co.com.parking.domain.domain.serviciovehiculo.interfaces.ServicioVehiculo;
import co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante;
import co.com.parking.domain.dto.CompositeResponse;
import co.com.parking.domain.dto.DiaHora;
import co.com.parking.persistence.domain.MovimientoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;
import co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository;

@Service
public class ServicioVigilanteImpl implements ServicioVigilante {

	@Autowired
	ServicioVehiculo servicioVehiculo;
	@Autowired
	ServicioParqueadero servicioParqueadero;
	@Autowired
	ServicioCalculadora servicioCalculadora;
	@Autowired
	ServicioCalendario servicioCalendario;
	
	private ServicioVigilanteRepository servicioVigilanteRepository;

	public ServicioVigilanteImpl(ServicioVigilanteRepository servicioVehiculoRepository) {
		this.servicioVigilanteRepository = servicioVehiculoRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante#saveVehicule(co.com.parking.persistence.domain.Vehiculo)
	 */
	public CompositeResponse saveVehicule(Vehiculo vehiculo) {
		MovimientoVehiculo movimientoVehiculo = null;
		CompositeResponse response = null;
		try {
			if(servicioVehiculo.validatePlacas(vehiculo.getPlaca())) {
				if(servicioParqueadero.cantidadVehiculos(vehiculo.getTipoVehiculo())) {
					servicioVigilanteRepository.saveVehicule(vehiculo);
					
					movimientoVehiculo = new MovimientoVehiculo();
					movimientoVehiculo.setVehiculo(vehiculo);
					movimientoVehiculo.setFechaInicio(new Date());
					movimientoVehiculo.setParqueado(true);
					servicioVigilanteRepository.saveMovimientoVehicule(movimientoVehiculo);
					
					response = new CompositeResponse(CompositeResponse.SUCCESS,MensajesRespuesta.ALMACENAMIENTO_VEHICULO_EXITOSO);	
				}else {
					response = new CompositeResponse(CompositeResponse.INFO,MensajesRespuesta.PARQUEADERO_LLENO);	
				}
			}else {
				response = new CompositeResponse(CompositeResponse.INFO,MensajesRespuesta.PLACA_INVALIDA_X_DIAS);
			}
		} catch (Exception e) {
			response = new CompositeResponse(CompositeResponse.ERROR,MensajesRespuesta.ERROR_SISTEMA);
			e.printStackTrace();
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante#outVehicule(co.com.parking.persistence.domain.Vehiculo)
	 */
	public int outVehicule(Vehiculo vehiculo) {
		DiaHora diaHora= null;
		int valorTotal = 0;
		CompositeResponse response = null;
		servicioVehiculo = new ServicioMoto();
		
		try {
			//Obtenemos la informacion del movimiento
			MovimientoVehiculo movimientoVehiculo = servicioVigilanteRepository.findMovimientoVehiculoByVehiculo(vehiculo);
			movimientoVehiculo.setFechaFin(new Date());
			//Obtenemos el tiempo de estancia en el parquadero
			diaHora = servicioCalendario.obtenerDiasHoras(movimientoVehiculo.getFechaInicio(), movimientoVehiculo.getFechaFin());
			valorTotal = getValorTotal(vehiculo, diaHora);
			//Actualizamos la estancia en el parqueadero
			movimientoVehiculo.setParqueado(false);
			servicioVigilanteRepository.updateVehicule(movimientoVehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return valorTotal;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante#getValorTotal(co.com.parking.persistence.domain.Vehiculo, co.com.parking.domain.dto.DiaHora)
	 */
	public int getValorTotal(Vehiculo vehiculo, DiaHora diaHora) {
		int valorTotal = 0;
		switch (vehiculo.getTipoVehiculo().getIdTipoVehiculo()) {
		case TipoVehiculo.CARRO:
			valorTotal = servicioCalculadora.calcularDiasHoras(diaHora, TablaPrecios.VALOR_HORA_CARRO, TablaPrecios.VALOR_DIA_CARRO);
			break;
		case TipoVehiculo.MOTO:
			valorTotal = servicioCalculadora.calcularDiasHoras(diaHora, TablaPrecios.VALOR_HORA_MOTO, TablaPrecios.VALOR_DIA_MOTO);
			
			if(servicioVehiculo.validateCilindraje(vehiculo.getCilindraje())) {
				valorTotal = valorTotal + TablaPrecios.VALOR_ADICIONAL_500CC;
			}
			break;
		}
		return valorTotal;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante#findVehicules()
	 */
	public List<MovimientoVehiculo> findVehicules() {
		List<MovimientoVehiculo> listMovimientoVehiculo = null;
		try {
			listMovimientoVehiculo = servicioVigilanteRepository.findVehicules();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMovimientoVehiculo;
	}

	
}
