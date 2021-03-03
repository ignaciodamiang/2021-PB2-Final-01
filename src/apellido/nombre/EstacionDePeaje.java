package apellido.nombre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EstacionDePeaje {

	private List<Cabina> cabinas;

	private Integer cantidadDeCabinas;

	/*
	 * Al momento de la creacion de la estacion de peajes se deben crear todas las
	 * cabianas donde en la posicion 0 hay una cabina de Telepase y el resto de las
	 * cabinas son comunes
	 */

	public EstacionDePeaje(Integer cantidadDeCabinas) {
		this.cantidadDeCabinas = cantidadDeCabinas;
		this.cabinas = new ArrayList<Cabina>();
		agregarCabinas();
	}

	// Metodo que agrega todas las cabinas (No Obligatorio)
	private void agregarCabinas() {
		Integer numeroCabina = 0;
		for (int i = 0; i < cantidadDeCabinas; i++) {
			if (numeroCabina == 0) {
				Telepase telepase = new Telepase(numeroCabina);
				this.cabinas.add(telepase);
			} else {
				this.cabinas.add(new Cabina(numeroCabina));
			}
			numeroCabina++;
		}
	}

	public Cabina getCabinas(Integer n) {
		if (n > 0) {
			return cabinas.get(n);
		} else {
			return null;
		}
	}

	public Telepase getTelepase() {
		return (Telepase) cabinas.get(0);
	}

	/*
	 * obtiene todas un listado de cabinas ordenas por importe recaudado en forma
	 * descendete
	 */
	public Set<Cabina> otenerCabinasOrdenadaImporteDescendente(OrdenCabinaPorRecaudacion orden) {
		TreeSet<Cabina> cabinasOrdenadas = new TreeSet<Cabina>(new OrdenCabinaPorRecaudacion());
		cabinasOrdenadas.addAll(cabinas);
		return cabinasOrdenadas;
	}

	public Integer getCantidadDeCabinas() {
		return cantidadDeCabinas;
	}
}
