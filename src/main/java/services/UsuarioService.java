package services;

import java.util.List;

import model.TipoAtraccion;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, String contrasenia, TipoAtraccion preferencia, Integer presupuesto, Double tiempo) {
		Usuario usuario = new Usuario(-1, nombre, contrasenia, preferencia, presupuesto, tiempo, false);
		usuario.setContrasenia(contrasenia);

		if (usuario.isValid()) {
			DAOFactory.getUsuarioDAO().insert(usuario);
		}

		return usuario;
	}
	
	public void delete(Integer id) {
		Usuario usuario = new Usuario(id, null, null, null, 0, 0, null);

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.delete(usuario);
	}
	
	public Usuario find(Integer id) {
		return DAOFactory.getUsuarioDAO().find(id);
	}
	
	public Usuario update(Integer id, String nombre, String contrasenia, TipoAtraccion preferencia, Integer presupuesto, Double tiempo) {

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(id);

		usuario.setNombre(nombre);
		usuario.setContrasenia(contrasenia);
		usuario.setPreferencia(preferencia);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempo);

		if (usuario.isValid()) {
			usuarioDAO.update(usuario);
		}

		return usuario;
	}
}
