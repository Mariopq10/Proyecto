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
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField userFieldRegistro;
	private JPasswordField passwordFieldRegistro;
	private JTextField emailField;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		try {
			BufferedImage fondo = ImageIO.read(new File("./imagenes/bearlogo.jpg"));
			
			g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public PantallaRegistro(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		this.setSize(1280, 720);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 180, 716, 180, 100, 0};
		gridBagLayout.rowHeights = new int[]{193, 30, 29, 29, 30, 30, 20, 30, 30, 117, 81, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
						
								JLabel lblEmail = new JLabel("Email");
								lblEmail.setForeground(new Color(128, 113, 85));
								lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
								lblEmail.setBackground(Color.WHITE);
								GridBagConstraints gbc_lblEmail = new GridBagConstraints();
								gbc_lblEmail.anchor = GridBagConstraints.WEST;
								gbc_lblEmail.fill = GridBagConstraints.VERTICAL;
								gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
								gbc_lblEmail.gridx = 1;
								gbc_lblEmail.gridy = 1;
								add(lblEmail, gbc_lblEmail);
						
								emailField = new JTextField();
								emailField.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
								emailField.setForeground(Color.BLACK);
								emailField.setColumns(10);
								emailField.setBackground(new Color(219, 213, 200));
								GridBagConstraints gbc_emailField = new GridBagConstraints();
								gbc_emailField.fill = GridBagConstraints.BOTH;
								gbc_emailField.insets = new Insets(0, 0, 5, 5);
								gbc_emailField.gridx = 1;
								gbc_emailField.gridy = 2;
								add(emailField, gbc_emailField);
				
						JLabel labelUsuario = new JLabel("Usuario");
						labelUsuario.setBackground(new Color(255, 255, 255));
						labelUsuario.setForeground(new Color(128, 113, 85));
						labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
						GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
						gbc_labelUsuario.anchor = GridBagConstraints.WEST;
						gbc_labelUsuario.fill = GridBagConstraints.VERTICAL;
						gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
						gbc_labelUsuario.gridx = 1;
						gbc_labelUsuario.gridy = 3;
						add(labelUsuario, gbc_labelUsuario);
		
				userFieldRegistro = new JTextField();
				userFieldRegistro.setBackground(new Color(219, 213, 200));
				userFieldRegistro.setForeground(Color.BLACK);
				userFieldRegistro.setColumns(10);
				GridBagConstraints gbc_userFieldRegistro = new GridBagConstraints();
				gbc_userFieldRegistro.anchor = GridBagConstraints.NORTH;
				gbc_userFieldRegistro.fill = GridBagConstraints.HORIZONTAL;
				gbc_userFieldRegistro.insets = new Insets(0, 0, 5, 5);
				gbc_userFieldRegistro.gridx = 1;
				gbc_userFieldRegistro.gridy = 4;
				add(userFieldRegistro, gbc_userFieldRegistro);
		
				JLabel labelContrasena = new JLabel("Contraseña");
				labelContrasena.setForeground(new Color(128, 113, 85));
				labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
				GridBagConstraints gbc_labelContrasena = new GridBagConstraints();
				gbc_labelContrasena.anchor = GridBagConstraints.WEST;
				gbc_labelContrasena.fill = GridBagConstraints.VERTICAL;
				gbc_labelContrasena.insets = new Insets(0, 0, 5, 5);
				gbc_labelContrasena.gridx = 1;
				gbc_labelContrasena.gridy = 5;
				add(labelContrasena, gbc_labelContrasena);
		
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
						
								passwordFieldRegistro = new JPasswordField();
								passwordFieldRegistro.setBackground(new Color(219, 213, 200));
								GridBagConstraints gbc_passwordFieldRegistro = new GridBagConstraints();
								gbc_passwordFieldRegistro.anchor = GridBagConstraints.NORTH;
								gbc_passwordFieldRegistro.fill = GridBagConstraints.HORIZONTAL;
								gbc_passwordFieldRegistro.insets = new Insets(0, 0, 5, 5);
								gbc_passwordFieldRegistro.gridx = 1;
								gbc_passwordFieldRegistro.gridy = 6;
								add(passwordFieldRegistro, gbc_passwordFieldRegistro);
				botonRegistro_1.setToolTipText("Pincha para registrarte");
				botonRegistro_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
				botonRegistro_1.setBackground(Color.LIGHT_GRAY);
				GridBagConstraints gbc_botonRegistro_1 = new GridBagConstraints();
				gbc_botonRegistro_1.fill = GridBagConstraints.BOTH;
				gbc_botonRegistro_1.insets = new Insets(0, 0, 0, 5);
				gbc_botonRegistro_1.gridx = 1;
				gbc_botonRegistro_1.gridy = 10;
				add(botonRegistro_1, gbc_botonRegistro_1);
		
				JButton botonLogin = new JButton("Volver");
				botonLogin.setToolTipText("Pincha para iniciar");
				botonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
				botonLogin.setBackground(Color.LIGHT_GRAY);
				GridBagConstraints gbc_botonLogin = new GridBagConstraints();
				gbc_botonLogin.insets = new Insets(0, 0, 0, 5);
				gbc_botonLogin.fill = GridBagConstraints.BOTH;
				gbc_botonLogin.gridx = 3;
				gbc_botonLogin.gridy = 10;
				add(botonLogin, gbc_botonLogin);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});

	}
}
