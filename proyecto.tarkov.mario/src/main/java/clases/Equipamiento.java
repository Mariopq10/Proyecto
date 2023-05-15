package clases;

public class Equipamiento extends ElementoConNombre {
	private float peso;
	private int precio;
	

	public Equipamiento(String nombre, float peso, int precio) {
		super(nombre);
		this.peso = peso;
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Equipamiento [peso=" + peso + "]";
	}

}
