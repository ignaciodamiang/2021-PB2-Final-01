package apellido.nombre;

import java.util.Comparator;

public class OrdenCabinaPorRecaudacion implements Comparator<Cabina> {

	@Override
	public int compare(Cabina o1, Cabina o2) {
		return (int) (o2.getRecaudacion() - o1.getRecaudacion());
	}
}
