package persistence;

import java.util.List;
import model.Usuario;
import persistence.commons.GenericDAO;


public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract int updateUsuarios(List<Usuario> u1);
	public abstract Usuario findByNombre(String username);
}
