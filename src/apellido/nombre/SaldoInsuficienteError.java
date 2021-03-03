package apellido.nombre;

@SuppressWarnings("serial")
public class SaldoInsuficienteError extends Exception {
	public SaldoInsuficienteError(String mensaje) {
		super(mensaje);
	}
}
