package apellido.nombre;

public abstract class Vehiculo {

	private Tag telepase = null;
	private String Patente;

	public Vehiculo(String patente) {
		Patente = patente;
	}

	public abstract String getTipo();

	public Tag getTag() {
		return telepase;
	}

	public void setTelepase(Tag telepase) {
		this.telepase = telepase;
	}

	public String getPatente() {
		return Patente;
	}
}
