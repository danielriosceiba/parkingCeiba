package co.com.parking.domain.constantes;

public class Constantes {

	public static class TablaPrecios{
		public final static int VALOR_HORA_CARRO = 1000;
		public final static int VALOR_HORA_MOTO = 500;
		public final static int VALOR_DIA_CARRO = 8000;
		public final static int VALOR_DIA_MOTO= 4000;
		public final static int VALOR_ADICIONAL_500CC= 2000;
	}
	
	public static class MensajesRespuesta{
		public static final String ALMACENAMIENTO_VEHICULO_EXITOSO = "El vehiculo fue almacenado con exito";
		public static final String RETIRAR_VEHICULO_EXITOSO = "El vehiculo fue retirado exitosamente";
		public static final String NO_FUE_POSIBLE_ALMACENAR_LA_INFORMACION = "No fue posible almacenar la informacionn del vehiculo";
		public static final String PLACA_INVALIDA_X_DIAS = "No fue posible almacenar la informacion del vehiculo, las placas que empicen por la letra A solo pueden ingresar al parqueadero los dias Domingo y Lunes";
		public static final String PARQUEADERO_LLENO = "No fue posible almacenar la informacion del vehiculo, No hay disponibilidad de parqueaderos";
		public static final String ERROR_SISTEMA = "Se ha presentado un error en el sistema.";
	}
	
	public static class TipoVehiculo{
		public static final int CARRO = 1;
		public static final int MOTO = 2;
	}

}
