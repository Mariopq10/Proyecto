package clases;

import java.util.HashSet;

import enums.ModoDisparo;

public class Arma extends Equipamiento {
	private String descripcion;
	private String calibre;
	private Municion municion;
	private Float retroceso;
	private Short rpm;
	private Short alcance;
	private byte ergonomia;
	private ModoDisparo modoDisparo;
	private HashSet<Acople> acoples;

	public Arma(String nombre, float peso, int precio, String descripcion, String calibre, Municion municion,
			Float retroceso, Short rpm, Short alcance, byte ergonomia, ModoDisparo modoDisparo,
			HashSet<Acople> acoples) {
		super(nombre, peso, precio);
		this.descripcion = descripcion;
		this.calibre = calibre;
		this.municion = municion;
		this.retroceso = retroceso;
		this.rpm = rpm;
		this.alcance = alcance;
		this.ergonomia = ergonomia;
		this.modoDisparo = modoDisparo;
		this.acoples = acoples;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public Municion getMunicion() {
		return municion;
	}

	public void setMunicion(Municion municion) {
		this.municion = municion;
	}

	public Float getRetroceso() {
		return retroceso;
	}

	public void setRetroceso(Float retroceso) {
		this.retroceso = retroceso;
	}

	public Short getRpm() {
		return rpm;
	}

	public void setRpm(Short rpm) {
		this.rpm = rpm;
	}

	public Short getAlcance() {
		return alcance;
	}

	public void setAlcance(Short alcance) {
		this.alcance = alcance;
	}

	public byte getErgonomia() {
		return ergonomia;
	}

	public void setErgonomia(byte ergonomia) {
		this.ergonomia = ergonomia;
	}

	public ModoDisparo getModoDisparo() {
		return modoDisparo;
	}

	public void setModoDisparo(ModoDisparo modoDisparo) {
		this.modoDisparo = modoDisparo;
	}

	public HashSet<Acople> getAcoples() {
		return acoples;
	}

	public void setAcoples(HashSet<Acople> acoples) {
		this.acoples = acoples;
	}

	@Override
	public String toString() {
		return "Arma [descripcion=" + descripcion + ", calibre=" + calibre + ", municion=" + municion + ", retroceso="
				+ retroceso + ", rpm=" + rpm + ", alcance=" + alcance + ", ergonomia=" + ergonomia + ", modoDisparo="
				+ modoDisparo + ", acoples=" + acoples + "]";
	}

}
