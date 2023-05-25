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
import java.awt.Graphics;

import javax.swing.JSlider;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField userField;
	private JPasswordField passwordField;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		try {
			BufferedImage fondo = ImageIO.read(new File("./imagenes/useclogo.jpg"));
			
			g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public PantallaLogin(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		this.setSize(1280, 720);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 180, 716, 180, 100, 0};
		gridBagLayout.rowHeights = new int[]{192, 30, 30, 29, 30, 30, 30, 24, 36, 117, 81, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(new Color(128, 113, 85));
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 1;
		add(labelUsuario, gbc_labelUsuario);
		
		userField = new JTextField();
		userField.setBackground(new Color(219, 213, 200));
		userField.setForeground(new Color(0, 0, 0));
		userField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userField.gridx = 1;
		gbc_userField.gridy = 2;
		add(userField, gbc_userField);
		userField.setColumns(10);
		
		JLabel labelContrasena = new JLabel("Contraseña");
		labelContrasena.setForeground(new Color(128, 113, 85));
		labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		GridBagConstraints gbc_labelContrasena = new GridBagConstraints();
		gbc_labelContrasena.anchor = GridBagConstraints.WEST;
		gbc_labelContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_labelContrasena.gridx = 1;
		gbc_labelContrasena.gridy = 3;
		add(labelContrasena, gbc_labelContrasena);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(219, 213, 200));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setBackground(Color.LIGHT_GRAY);
		buttonLogin.addMouseListener(new MouseAdapter() {
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
					JOptionPane.showMessageDialog(ventana, "No hay conexion con la base de datos",
							"Inicio de sesion incorrecto", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (ContrasenaInvalidaException e1) {
					JOptionPane.showMessageDialog(ventana, "Contrasena incorrecta", "Inicio de sesion incorrecto",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		buttonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		GridBagConstraints gbc_buttonLogin = new GridBagConstraints();
		gbc_buttonLogin.fill = GridBagConstraints.BOTH;
		gbc_buttonLogin.insets = new Insets(0, 0, 0, 5);
		gbc_buttonLogin.gridx = 1;
		gbc_buttonLogin.gridy = 10;
		add(buttonLogin, gbc_buttonLogin);
		
		JButton buttonRegistro = new JButton("Registro");
		buttonRegistro.setBackground(Color.LIGHT_GRAY);
		buttonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		buttonRegistro.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		GridBagConstraints gbc_buttonRegistro = new GridBagConstraints();
		gbc_buttonRegistro.fill = GridBagConstraints.BOTH;
		gbc_buttonRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_buttonRegistro.gridx = 3;
		gbc_buttonRegistro.gridy = 10;
		add(buttonRegistro, gbc_buttonRegistro);
		this.setVisible(true);

	}
}
