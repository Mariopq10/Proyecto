package vistas;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField userFieldRegistro;
	private JPasswordField passwordFieldRegistro;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		this.setSize(600, 500);
		
		JComboBox selectorProvincia = new JComboBox();
		selectorProvincia.setBackground(new Color(219, 213, 200));
		selectorProvincia.setModel(new DefaultComboBoxModel(new String[] {"Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla"}));
		selectorProvincia.setBounds(34, 210, 149, 21);
		add(selectorProvincia);
		
		JLabel labelProvincia = new JLabel("Selecciona provincia");
		labelProvincia.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelProvincia.setForeground(new Color(128, 113, 85));
		labelProvincia.setBounds(34, 184, 149, 19);
		add(labelProvincia);
		
		userFieldRegistro = new JTextField();
		userFieldRegistro.setBackground(new Color(219, 213, 200));
		userFieldRegistro.setForeground(Color.BLACK);
		userFieldRegistro.setColumns(10);
		userFieldRegistro.setBounds(444, 211, 104, 20);
		add(userFieldRegistro);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBackground(new Color(255, 255, 255));
		labelUsuario.setForeground(new Color(128, 113, 85));
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelUsuario.setBounds(444, 183, 93, 23);
		add(labelUsuario);
		
		JLabel labelContrasena = new JLabel("Contrasena");
		labelContrasena.setForeground(new Color(128, 113, 85));
		labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelContrasena.setBounds(444, 250, 79, 14);
		add(labelContrasena);
		
		passwordFieldRegistro = new JPasswordField();
		passwordFieldRegistro.setBackground(new Color(219, 213, 200));
		passwordFieldRegistro.setBounds(444, 275, 104, 20);
		add(passwordFieldRegistro);
		
		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonRegistro.setBounds(444, 331, 104, 52);
		add(botonRegistro);
		
		JLabel fondoRegistro = new JLabel("New label");
		fondoRegistro.setIcon(new ImageIcon("C:\\Users\\1DAM&&1DAW\\Downloads\\useclogo.png"));
		fondoRegistro.setBounds(0, 0, 600, 500);
		add(fondoRegistro);
		this.setVisible(true);
		
		
	}
}
