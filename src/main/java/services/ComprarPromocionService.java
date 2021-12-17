package services;
import java.util.HashMap;
import java.util.Map;
import model.Atraccion;
import model.Attraction;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class ComprarPromocionService {

	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer usuarioId, Integer promocionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDao.find(usuarioId);
		Promocion promocion = promocionDAO.find(promocionId);

		if (!promocion.canHost(1)) {
			errors.put("promocion", "No hay cupo disponible");
		}
		if (!usuario.canAfford(promocion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.canAttend(promocion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.agregarPromocionAItinerario(promocion);
			System.out.println("Cupo antes de host:" + promocion.getAtracciones().get(0).getCupo());
			promocion.host(1);
			System.out.println("Cupo despues de host:" + promocion.getAtracciones().get(0).getCupo());
			for(Atraccion atracc : promocion.getAtracciones()) {
				System.out.println(atracc);
				atraccionDAO.update(atracc);
			}
			promocionDAO.update(promocion);
			usuarioDao.update(usuario);
		}

		return errors;

	}

}
