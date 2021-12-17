package services;

import java.util.List;

import model.Atraccion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, TipoAtraccion tipo, Integer precio, Double duracion, Integer capacidad) {

		Atraccion atraccion = new Atraccion(-1, nombre, tipo, precio, capacidad, duracion);

		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
		}

		return atraccion;
	}

	public Atraccion update(Integer id, String nombre, TipoAtraccion tipo, Integer precio, Double duracion, Integer cupo) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setTipo(tipo);
		atraccion.setPrecio(precio);
		atraccion.setTiempo(duracion);
		atraccion.setCupo(cupo);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
		}

		return atraccion;
	}

	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(id, "", null, 0, 0, 0);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAtraccionDAO().find(id);
	}

}
