package services;

import model.Usuario;
import model.nullobjects.NullUsuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginUsuariosService {

	public Usuario login(String nombre, String contrasenia) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
    	Usuario usuario = usuarioDao.findByNombre(nombre);
    	
    	if (usuario.isNull() || !usuario.checkPassword(contrasenia)) {
    		usuario = NullUsuario.build();
    	}
    	return usuario;
	}
	
}
