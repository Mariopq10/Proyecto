package clases;

public class Equipamiento extends ElementoConNombre {

	public Equipamiento(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	private float peso;

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
