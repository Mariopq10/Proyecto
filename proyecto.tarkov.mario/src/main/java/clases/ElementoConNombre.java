package clases;

public class ElementoConNombre {
	protected String nombre;

	public ElementoConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public ElementoConNombre() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ElementoConNombre [nombre=" + nombre + "]";
	}

}
