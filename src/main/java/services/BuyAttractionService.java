/*package services;

import java.util.HashMap;
import java.util.Map;
import model.Attraction;
import model.Usuario;
import persistence.AttractionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class BuyAttractionService {

	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer usuarioId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDao.find(usuarioId);
		Attraction attraction = attractionDAO.find(attractionId);

		if (!attraction.canHost(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!usuario.canAfford(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!usuario.canAttend(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItinerary(attraction);
			attraction.host(1);

			attractionDAO.update(attraction);
			userDAO.update(user);
		}

		return errors;

	}

}
*/