package apellido.nombre;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCabina {

	@Test
	public void queVerificaQueCuenteCorrectamenteLaCantidadDeVehiculosQuePaSanPorUnacabina() {
		EstacionDePeaje estacion1 = new EstacionDePeaje(5);
		Coche coche1 = new Coche("123456");
		Coche coche2 = new Coche("345678");
		Moto moto1 = new Moto("234567");
		AutoBus bus1 = new AutoBus("456789", new Tag(1));

		estacion1.getCabinas(1).pagar(coche1);
		estacion1.getCabinas(1).pagar(coche2);
		estacion1.getCabinas(1).pagar(moto1);
		estacion1.getCabinas(1).pagar(bus1);

		Integer esperado = 4;
		Integer obtenido = estacion1.getCabinas(1).getContadorBuses() + estacion1.getCabinas(1).getContadorCoches()
				+ estacion1.getCabinas(1).getContadorMotos();

		assertEquals(esperado, obtenido);
	}

	@Test
	public void queVerificaQueSeRecaudeCorrectaMenteElPagoDeUnVehiculo() {
		EstacionDePeaje estacion1 = new EstacionDePeaje(5);
		Coche coche1 = new Coche("123456");
		Coche coche2 = new Coche("345678");
		Moto moto1 = new Moto("234567");
		AutoBus bus1 = new AutoBus("456789", new Tag(1));

		estacion1.getCabinas(1).pagar(coche1);
		estacion1.getCabinas(1).pagar(coche2);
		estacion1.getCabinas(1).pagar(moto1);
		estacion1.getCabinas(1).pagar(bus1);

		Double esperado = 450.0;
		Double obtenido = estacion1.getCabinas(1).getRecaudacion();

		assertEquals(esperado, obtenido);
	}

}
