package apellido.nombre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TelepaseTest {

	@Test
	public void queVerificaQueSeEncuentreElTagConIdUno() throws TagNoEncontradoException {
		// Para este test se debeinvocar al metodo public Boolean verifcarExiste(Tag
		// tag)
		// el mismo no se puede modificar
		Telepase cabinaTelepase = new Telepase(1);
		cabinaTelepase.verifcarExiste(new Tag(1));
	}

	@Test(expected = SaldoInsuficienteError.class)
	public void queAlPasarAutobusconSaldoInsuficienteLanceUnaExcepcion()
			throws TagNoEncontradoException, SaldoInsuficienteError {
		EstacionDePeaje estacion1 = new EstacionDePeaje(2);
		AutoBus bus1 = new AutoBus("123456", new Tag(123456));
		bus1.recargarTag(10.0);

		Boolean cargarTag = estacion1.getTelepase().cargarTag(bus1.getTag());
		assertTrue(cargarTag);

		estacion1.getTelepase().pagarAutomatico(bus1);

		Double esperado1 = 0.0;
		Double obtenido1 = estacion1.getTelepase().getRecaudacion();

		assertEquals(esperado1, obtenido1);
	}

	@Test(expected = TagNoEncontradoException.class)
	public void queAlPasarUnAutobusconUnTagInvalidoLanceUnaExcepcion()
			throws TagNoEncontradoException, SaldoInsuficienteError {
		{
			EstacionDePeaje estacion1 = new EstacionDePeaje(2);
			AutoBus bus1 = new AutoBus("123456", new Tag(123456));
			bus1.recargarTag(1000.0);

			estacion1.getTelepase().pagarAutomatico(bus1);

			Double esperado1 = 0.0;
			Double obtenido1 = estacion1.getTelepase().getRecaudacion();

			assertEquals(esperado1, obtenido1);
		}

	}
}