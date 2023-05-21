package vistas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import clases.Usuario;
import excepciones.ContrasenaInvalidaException;
import excepciones.UsuarioNoExisteException;
import vistas.PantallaListado;

import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel {
	private JTextField userField;
	private JPasswordField passwordField;
	private Ventana ventana;

	public PantallaLogin(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		this.setSize(1280, 720);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(new Color(128, 113, 85));
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelUsuario.setBounds(44, 212, 146, 28);
		add(labelUsuario);

		userField = new JTextField();
		userField.setBackground(new Color(219, 213, 200));
		userField.setBounds(44, 251, 189, 20);
		add(userField);
		userField.setColumns(10);

		JLabel labelContrasena = new JLabel("Contrasena");
		labelContrasena.setForeground(new Color(128, 113, 85));
		labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelContrasena.setBounds(44, 314, 79, 14);
		add(labelContrasena);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(219, 213, 200));
		passwordField.setBounds(44, 350, 189, 20);
		add(passwordField);

		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String usuario = userField.getText();
					String contrasena = new String(passwordField.getPassword());
					ventana.usuarioLogin = new Usuario(usuario,contrasena);
					JOptionPane.showMessageDialog(ventana, "Bienvenido/a, " + ventana.usuarioLogin.getNombre(),
							"Inicio de sesion correcto", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaListado.class);

				} catch (UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, "No existe el cliente", "Inicio de sesion incorrecto",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "No hay conexion con la base de datoss",
							"Inicio de sesion incorrecto", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (ContrasenaInvalidaException e1) {
					JOptionPane.showMessageDialog(ventana, "Contrasena incorrecta", "Inicio de sesion incorrecto",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLogin.setToolTipText("Pincha para iniciar");
		botonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonLogin.setBackground(new Color(192, 192, 192));
		botonLogin.setBounds(100, 555, 120, 81);
		add(botonLogin);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(569, 695, 146, 14);
		add(progressBar);

		JButton botonRegistro = new JButton("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		botonRegistro.setToolTipText("Pincha para registrarte");
		botonRegistro.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonRegistro.setBackground(Color.LIGHT_GRAY);
		botonRegistro.setBounds(1081, 555, 120, 81);
		add(botonRegistro);

		JLabel fondoLogin = new JLabel("New label");
		fondoLogin.setIcon(new ImageIcon(
				"C:\\Users\\mario\\Documents\\GitHub\\Proyecto\\proyecto.tarkov.mario\\imagenes\\useclogo.jpg"));
		fondoLogin.setBounds(0, 0, 1280, 720);
		add(fondoLogin);
		this.setVisible(true);

	}
}
