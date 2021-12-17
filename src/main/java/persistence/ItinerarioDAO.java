package persistence;

import java.util.List;

import model.Itinerario;
import model.Usuario;
import persistence.commons.GenericDAO;


public interface ItinerarioDAO extends GenericDAO<Itinerario>{

	public abstract int updateItinerario(List<Usuario> u1);
}
