package co.com.controller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.controller.response.Response;
import co.com.parking.domain.constantes.Constantes.MensajesRespuesta;
import co.com.parking.domain.domain.serviciovigilante.interfaces.ServicioVigilante;
import co.com.parking.domain.dto.CompositeResponse;
import co.com.parking.persistence.domain.Vehiculo;

@RestController 
@RequestMapping("/vehiculo")
public class VehiculoController {
//	
	@Autowired
	ServicioVigilante servicioVigilante;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@CrossOrigin
	public Response saveVehicule(@RequestBody Vehiculo vehiculo) {
		return Response.createResponse(servicioVigilante.saveVehicule(vehiculo));	
	}
	
	@RequestMapping(value = "/out", method = RequestMethod.POST)
	@CrossOrigin
	public Response outVehicule(@RequestBody Vehiculo vehiculo) {
		Response response;
		try {
			response = Response.createResponse(servicioVigilante.outVehicule(vehiculo)); 
		} catch (Exception e) {
			response = Response.createResponse(new CompositeResponse(CompositeResponse.ERROR,MensajesRespuesta.ERROR_SISTEMA));
		}	
		return response;
	}
	
	@RequestMapping(value="findVehicules",method=RequestMethod.GET)
	public Response findVehicules() {
		Response response;
		try {
			response = Response.createResponse(servicioVigilante.findVehicules());
		} catch (Exception e) {
			response = Response.createResponse(new CompositeResponse(CompositeResponse.ERROR,MensajesRespuesta.ERROR_SISTEMA));
		}
		return response;
	}
}
