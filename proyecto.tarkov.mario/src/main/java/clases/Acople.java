package clases;

import java.util.Arrays;

public class Acople extends Equipamiento {
	private String[] compatibilidad;

	public Acople(String nombre, float peso, int precio, String[] compatibilidad) {
		super(nombre, peso, precio);
		this.compatibilidad = compatibilidad;
	}

	public String[] getCompatibilidad() {
		return compatibilidad;
	}

	public void setCompatibilidad(String[] compatibilidad) {
		this.compatibilidad = compatibilidad;
	}

	@Override
	public String toString() {
		return "Acople [compatibilidad=" + Arrays.toString(compatibilidad) + "]";
	}

}
