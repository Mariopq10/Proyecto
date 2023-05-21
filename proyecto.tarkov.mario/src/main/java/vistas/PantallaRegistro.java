package vistas;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


import clases.Usuario;
import vistas.PantallaLogin;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField userFieldRegistro;
	private JPasswordField passwordFieldRegistro;
	private JTextField emailField;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		this.setSize(1280, 720);

		emailField = new JTextField();
		emailField.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		emailField.setForeground(Color.BLACK);
		emailField.setColumns(10);
		emailField.setBackground(new Color(219, 213, 200));
		emailField.setBounds(44, 227, 176, 20);
		add(emailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(128, 113, 85));
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(44, 193, 93, 23);
		add(lblEmail);

		JButton botonRegistro_1 = new JButton("Registro");
		botonRegistro_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = userFieldRegistro.getText();
					String contrasena = new String(passwordFieldRegistro.getPassword());
					String email = emailField.getText();
					new Usuario(email, nombre, contrasena);
					JOptionPane.showMessageDialog(ventana, "Registrado correctamente", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaLogin.class);
				} catch (SQLIntegrityConstraintViolationException e3) {
					JOptionPane.showMessageDialog(ventana, "El email ya exite", "No se pudo registrar",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "Conexion incorrecta", "No se puede conectar a la BD",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner solo numeros",
							"Numero de telefono incorrecto", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonRegistro_1.setToolTipText("Pincha para registrarte");
		botonRegistro_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonRegistro_1.setBackground(Color.LIGHT_GRAY);
		botonRegistro_1.setBounds(100, 555, 120, 81);
		add(botonRegistro_1);

		JComboBox selectorProvincia = new JComboBox();
		selectorProvincia.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		selectorProvincia.setBackground(new Color(219, 213, 200));
		selectorProvincia.setModel(new DefaultComboBoxModel(
				new String[] { "Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla" }));
		selectorProvincia.setBounds(44, 417, 176, 21);
		add(selectorProvincia);

		JLabel labelProvincia = new JLabel("Selecciona provincia");
		labelProvincia.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelProvincia.setForeground(new Color(128, 113, 85));
		labelProvincia.setBounds(44, 387, 149, 19);
		add(labelProvincia);

		userFieldRegistro = new JTextField();
		userFieldRegistro.setBackground(new Color(219, 213, 200));
		userFieldRegistro.setForeground(Color.BLACK);
		userFieldRegistro.setColumns(10);
		userFieldRegistro.setBounds(44, 292, 176, 20);
		add(userFieldRegistro);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBackground(new Color(255, 255, 255));
		labelUsuario.setForeground(new Color(128, 113, 85));
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelUsuario.setBounds(44, 258, 93, 23);
		add(labelUsuario);

		JLabel labelContrasena = new JLabel("Contrasena");
		labelContrasena.setForeground(new Color(128, 113, 85));
		labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelContrasena.setBounds(44, 323, 79, 14);
		add(labelContrasena);

		passwordFieldRegistro = new JPasswordField();
		passwordFieldRegistro.setBackground(new Color(219, 213, 200));
		passwordFieldRegistro.setBounds(44, 348, 176, 20);
		add(passwordFieldRegistro);

		JButton botonLogin = new JButton("Volver");
		botonLogin.setToolTipText("Pincha para iniciar");
		botonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonLogin.setBackground(Color.LIGHT_GRAY);
		botonLogin.setBounds(1080, 555, 120, 81);
		add(botonLogin);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});

		JLabel fondoRegistro = new JLabel("New label");
		fondoRegistro.setIcon(new ImageIcon(
				"C:\\Users\\mario\\Documents\\GitHub\\Proyecto\\proyecto.tarkov.mario\\imagenes\\bearlogo.jpg"));
		fondoRegistro.setBounds(0, -2, 1280, 720);
		add(fondoRegistro);
		this.setVisible(true);

	}
}
