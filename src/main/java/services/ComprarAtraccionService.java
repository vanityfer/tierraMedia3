package services;
import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Attraction;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class ComprarAtraccionService {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer usuarioId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDao.find(usuarioId);
		Atraccion atraccion = atraccionDAO.find(attractionId);

		if (!atraccion.canHost(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!usuario.canAfford(atraccion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!usuario.canAttend(atraccion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.agregarAtraccionAItinerario(atraccion);
			atraccion.host(1);

			atraccionDAO.update(atraccion);
			usuarioDao.update(usuario);
		}

		return errors;

	}

}
