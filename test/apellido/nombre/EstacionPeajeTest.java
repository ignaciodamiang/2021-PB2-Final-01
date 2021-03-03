package apellido.nombre;

import static org.junit.Assert.assertEquals;

import java.util.TreeSet;

import org.junit.Test;

public class EstacionPeajeTest {

	@Test
	public void queVericaQueSeCreanTodasCabinasEnUnaEstacionDePeaje() {
		EstacionDePeaje nuevaEstacionDePeaje = new EstacionDePeaje(5);
		Integer cabinasEsperadas = 5;
		Integer cantidadDeCabinas = nuevaEstacionDePeaje.getCantidadDeCabinas();
		assertEquals(cabinasEsperadas, cantidadDeCabinas);
	}

	@Test
	public void queQueObtieneListaDeCabinasOrdenaPorImporteDescendente() {
		EstacionDePeaje nuevaEstacionDePeaje = new EstacionDePeaje(5);
		Vehiculo v1 = new Coche("qqq111");

		nuevaEstacionDePeaje.getCabinas(3).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(3).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(3).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(3).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(2).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(2).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(2).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(1).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(1).pagar(v1);
		nuevaEstacionDePeaje.getCabinas(4).pagar(v1);
		
		OrdenCabinaPorRecaudacion ordenPorRecaudacion = new OrdenCabinaPorRecaudacion();
		
		TreeSet<Cabina> cabinasOrdenadas = new TreeSet<Cabina>(new OrdenCabinaPorRecaudacion());
		cabinasOrdenadas = (TreeSet<Cabina>) nuevaEstacionDePeaje.otenerCabinasOrdenadaImporteDescendente(ordenPorRecaudacion);
		
		
		Integer obtenido1 = cabinasOrdenadas.first().getNumero();
		Integer esperado1 = 3;
		assertEquals(esperado1, obtenido1);
		
		Integer obtenido2 = cabinasOrdenadas.last().getNumero();
		Integer esperado2 = 0;
		assertEquals(esperado2, obtenido2);
	}

}
