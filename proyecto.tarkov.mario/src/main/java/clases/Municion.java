package clases;

import java.util.Arrays;

public class Municion extends Equipamiento {
	private String tipo;
	private Byte dano;
	private Byte penetracion;
	private String[] compatibilidad;

	public Municion(String nombre, float peso, int precio, String tipo, Byte dano, Byte penetracion,
			String[] compatibilidad) {
		super(nombre, peso, precio);
		this.tipo = tipo;
		this.dano = dano;
		this.penetracion = penetracion;
		this.compatibilidad = compatibilidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Byte getDano() {
		return dano;
	}

	public void setDano(Byte dano) {
		this.dano = dano;
	}

	public Byte getPenetracion() {
		return penetracion;
	}

	public void setPenetracion(Byte penetracion) {
		this.penetracion = penetracion;
	}

	public String[] getCompatibilidad() {
		return compatibilidad;
	}

	public void setCompatibilidad(String[] compatibilidad) {
		this.compatibilidad = compatibilidad;
	}

	@Override
	public String toString() {
		return "Municion [tipo=" + tipo + ", dano=" + dano + ", penetracion=" + penetracion + ", compatibilidad="
				+ Arrays.toString(compatibilidad) + "]";
	}

}
