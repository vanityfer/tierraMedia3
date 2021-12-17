package services;

import java.util.List;

import model.Atraccion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.TipoAtraccionDAO;
import persistence.commons.DAOFactory;

public class TipoAtraccionService {

	public List<TipoAtraccion> list() {
		return DAOFactory.getTipoAtraccionDAO().findAll();
	}

	public TipoAtraccion create(String nombre) {

		TipoAtraccion tipoAtraccion = new TipoAtraccion(-1, nombre);
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		tipoAtraccionDAO.insert(tipoAtraccion);
		return tipoAtraccion;
	}

	public TipoAtraccion update(Integer id, String nombre) {

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tipoAtraccion = tipoAtraccionDAO.find(id);

		tipoAtraccion.setName(nombre);
		tipoAtraccionDAO.update(tipoAtraccion);
		return tipoAtraccion;
	}

	public void delete(Integer id) {
		TipoAtraccion tipoAtraccion = new TipoAtraccion(id, "");

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		tipoAtraccionDAO.delete(tipoAtraccion);
	}

	public TipoAtraccion find(Integer id) {
		return DAOFactory.getTipoAtraccionDAO().find(id);
	}

}
