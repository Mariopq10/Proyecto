package vistas;

import javax.swing.JFrame;

import clases.Usuario;
import vistas.PantallaLogin;
import vistas.PantallaRegistro;

public class Ventana extends JFrame {
	protected Usuario usuarioLogin;

	public Ventana() {
		this.setSize(1280, 720);
		this.setTitle("Tarkov Builder");
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