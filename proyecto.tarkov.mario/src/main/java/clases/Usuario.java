package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.UsuarioNoExisteException;
import excepciones.ContrasenaInvalidaException;
import utils.DAO;

public class Usuario extends ElementoConNombre {

	private String email;
	private ArrayList<Personaje> personajes;

	public Usuario(String nombre, String email, ArrayList<Personaje> personajes) {
		super(nombre);
		this.email = email;
		this.personajes = personajes;
	}

	// Constructor para la base de datos
	public Usuario(String email, String nombre, String contrasena) throws SQLException {
		super(nombre);
		HashMap<String, Object> cols = new HashMap<String, Object>();
		cols.put("email", this.email = email);
		cols.put("nombre", this.getNombre());
		cols.put("password", contrasena);
		DAO.insertar("usuario", cols);
	}

	public Usuario(String nombre, String contrasena)
			throws UsuarioNoExisteException, SQLException, ContrasenaInvalidaException {
		super(nombre);
		LinkedHashSet<String> columnasSelect = new LinkedHashSet();
		columnasSelect.add("nombre");
		columnasSelect.add("password");
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("nombre", nombre);
		ArrayList<Object> consulta = DAO.consultar("usuario", columnasSelect, restricciones);
		if (consulta.isEmpty()) {
			throw new UsuarioNoExisteException("No existe el cliente");
		} else if (!consulta.get(1).equals(contrasena)) {
			throw new ContrasenaInvalidaException("La contrasena es invalida");
		} else {
			this.setNombre((String) consulta.get(0));
			//this.email = (String) consulta.get(1);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", personajes=" + personajes + "]";
	}

}
