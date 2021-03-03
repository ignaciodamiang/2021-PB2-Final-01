package apellido.nombre;

import java.util.Map;
import java.util.TreeMap;

public class Cabina {

	/*
	 * Fornato del Contador de vehiculo ejemplo Clave valor Moto 6 AutoBus 3 Moto 2
	 * 
	 */
	private Map<String, Integer> contadorDeVehiculos;
	private Integer numero;

	/*
	 * 
	 */
	private Double tarifaCoche;
	private Double tarifaMoto;
	private Double tarifaAutoBus;

	/* recaudacion total de todos los vehiculos que pasaron por dicha cabina */
	private Double recaudacion;
	private Integer contadorMotos=0;
	private Integer contadorCoches=0;
	private Integer contadorBuses=0;

	public Cabina(Integer numero) {
		this.numero = numero;
		this.recaudacion = 0.0;
		this.tarifaAutoBus = 200.0;
		this.tarifaCoche = 100.0;
		this.tarifaMoto = 50.0;
		this.contadorDeVehiculos = new TreeMap<String, Integer>();
		// Completar la inicializacion de los atributos restantes
	}

	/*
	 * Este metodo realiza el cobro y acumula la recaudacion de la cabina en funcion
	 * al tipo de auto Tambien contabiliza la cantidad de vehiculo ejemplo si es
	 * moto aumenta en uno el contador de moto
	 */
	public void pagar(Vehiculo vehiculo) {
		String tipoDeVehiculo = vehiculo.getTipo();
		switch (tipoDeVehiculo) {
		case "Coche":
			this.recaudacion = recaudacion + tarifaCoche;
			contarVehiculo(vehiculo);
			break;
		case "Moto":
			this.recaudacion = recaudacion + tarifaMoto;
			contarVehiculo(vehiculo);
			break;
		case "AutoBus":
			this.recaudacion = recaudacion + tarifaAutoBus;
			contarVehiculo(vehiculo);
			break;
		default:
			break;
		}
	}

	/*
	 * incrementa el contadorDeVehiculo
	 */
	private void contarVehiculo(Vehiculo vehiculo) {
		String tipoDeVehiculo = vehiculo.getTipo();
		
		switch (tipoDeVehiculo) {
		case "Moto":
			contadorDeVehiculos.put("Moto", ++contadorMotos);
			break;
		case "Coche":
			contadorDeVehiculos.put("Coche", ++contadorCoches);
			break;
		case "AutoBus":
			contadorDeVehiculos.put("AutoBus", ++contadorBuses);
			break;
		default:
			break;
		}
	}
	
	public Double getRecaudacion() {
		return recaudacion;
	}
	
	public Double getTarifaCoche() {
		return tarifaCoche;
	}

	public Double getTarifaMoto() {
		return tarifaMoto;
	}

	public Double getTarifaAutoBus() {
		return tarifaAutoBus;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public Map<String, Integer> getContadorDeVehiculos() {
		return contadorDeVehiculos;
	}

	public Integer getContadorMotos() {
		return contadorMotos;
	}

	public Integer getContadorCoches() {
		return contadorCoches;
	}

	public Integer getContadorBuses() {
		return contadorBuses;
	}

	@Override
	public String toString() {
		return "Cabina [numero=" + numero + ", recaudacion=" + recaudacion + "]";
	}
}
