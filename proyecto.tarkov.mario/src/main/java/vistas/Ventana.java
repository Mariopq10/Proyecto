package vistas;

import javax.swing.JFrame;

import vistas.PantallaLogin;
import vistas.PantallaRegistro;

public class Ventana extends JFrame {
	public Ventana() {
		this.setSize(600, 500);
		this.setTitle("Programita");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if (clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		this.getContentPane().setVisible(true);
	}
}