package co.com.parking.persistence.repository.serviciovigilante;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.parking.persistence.base.BaseRepository;
import co.com.parking.persistence.converter.MovimientoVehiculoConverter;
import co.com.parking.persistence.converter.VehiculoConverter;
import co.com.parking.persistence.domain.MovimientoVehiculo;
import co.com.parking.persistence.domain.Vehiculo;
import co.com.parking.persistence.entity.MovimientoVehiculoEntity;
import co.com.parking.persistence.entity.VehiculoEntity;
import co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository;

@Repository
public class ServicioVigilanteRepositoryImpl extends BaseRepository implements ServicioVigilanteRepository{

	@Autowired
	VehiculoConverter vehiculoConverter; 
	@Autowired
	MovimientoVehiculoConverter movimientoVehiculoConverter;
	
	/*
	 * (non-Javadoc)
	 * @see co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository#saveVehicule(co.com.parking.persistence.domain.Vehiculo)
	 */
	@Transactional
	public boolean saveVehicule(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = vehiculoConverter.domainToEntity(vehiculo);
		this.entityManager.persist(vehiculoEntity);
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository#saveMovimientoVehicule(co.com.parking.persistence.domain.MovimientoVehiculo)
	 */
	@Transactional
	public boolean saveMovimientoVehicule(MovimientoVehiculo movimientoVehiculo) {
		MovimientoVehiculoEntity movimientoVehiculoEntity = movimientoVehiculoConverter.domainToEntity(movimientoVehiculo);
		this.entityManager.persist(movimientoVehiculoEntity);
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository#findVehicules()
	 */
	@SuppressWarnings("unchecked")
	public List<MovimientoVehiculo> findVehicules(){
		List<MovimientoVehiculo> list = null;
		
		String sqlQuery = "select * from movimiento_vehiculo mv inner join vehiculo ve on mv.id_vehiculo= ve.id_vehiculo inner join tipo_vehiculo tv on ve.id_tipo_vehiculo = tv.id_tipo_vehiculo where mv.parqueado = true";
		Query query = entityManager.createNativeQuery(sqlQuery, MovimientoVehiculoEntity.class);
		list = query.getResultList();
		return list;
	}
	
	public MovimientoVehiculo findMovimientoVehiculoByVehiculo(Vehiculo vehiculo) {
		MovimientoVehiculoEntity movimientoVehiculoEntity = null; 
		
		String sqlQuery = "select * from movimiento_vehiculo mv inner join vehiculo ve on mv.id_vehiculo = ve.id_vehiculo  where ve.id_vehiculo = ? and mv.parqueado = true";
		Query query = entityManager.createNativeQuery(sqlQuery, MovimientoVehiculoEntity.class);
		query.setParameter(1, vehiculo.getIdVehiculo()); 
		movimientoVehiculoEntity = (MovimientoVehiculoEntity) query.getSingleResult();
		return movimientoVehiculoConverter.entityToDomain(movimientoVehiculoEntity);
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.com.parking.persistence.repository.serviciovigilante.interfaces.ServicioVigilanteRepository#updateVehicule(co.com.parking.persistence.domain.MovimientoVehiculo)
	 */
	@Transactional
	public boolean updateVehicule(MovimientoVehiculo movimientoVehiculo) {
		MovimientoVehiculoEntity movimientoVehiculoEntity = movimientoVehiculoConverter.domainToEntity(movimientoVehiculo);
		this.entityManager.persist(movimientoVehiculoEntity);
		return true;
	}
}
