package co.com.parking.persistence.repository.servicioparqueadero;

import java.math.BigInteger;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.com.parking.persistence.base.BaseRepository;
import co.com.parking.persistence.domain.TipoVehiculo;
import co.com.parking.persistence.repository.servicioparqueadero.interfaces.ServicioParqueaderoRepository;

@Repository
public class ServicioParqueaderoRepositoryImpl extends BaseRepository implements ServicioParqueaderoRepository{

	public Integer cantidadVehiculos(TipoVehiculo tipoVehiculo) {
		
		String sqlQuery = "select count(*) from movimiento_vehiculo mv inner join vehiculo ve on ve.id_vehiculo = mv.id_vehiculo where ve.id_tipo_vehiculo = ? and mv.parqueado = true";
		Query query = entityManager.createNativeQuery(sqlQuery);
		query.setParameter(1, tipoVehiculo.getIdTipoVehiculo());
		return new BigInteger(String.valueOf(query.getSingleResult())).intValue();
	}
}
