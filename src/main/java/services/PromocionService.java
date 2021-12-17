package services;

import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Promocion3x2;
import model.PromocionFinal;
import model.PromocionPorcentual;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Promocion create(String nombre, Integer precioFinal, Integer descuento, Integer idAtraccion1, Integer idAtraccion2, Integer idAtraccion3) {
		Promocion promocion;
		AtraccionDAO atraccDAO = DAOFactory.getAtraccionDAO();
		List <Atraccion> atracciones; 
		if(precioFinal != 0) {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(atraccDAO.find(idAtraccion1));
			atracciones.add(atraccDAO.find(idAtraccion2));
			promocion = new PromocionFinal(-1, nombre, atracciones, precioFinal);
			}
		else if(descuento != 0) {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(atraccDAO.find(idAtraccion1));
			atracciones.add(atraccDAO.find(idAtraccion2));
			promocion = new PromocionPorcentual(-1, nombre, atracciones, descuento);
			}
		else {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(atraccDAO.find(idAtraccion1));
			atracciones.add(atraccDAO.find(idAtraccion2));
			atracciones.add(atraccDAO.find(idAtraccion3));
			promocion = new Promocion3x2(-1, nombre, atracciones);
			}
	
		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
		}

		return promocion;
	}
	
	public Promocion update(Integer id, String nombre, Integer precioFinal, Integer descuento, Integer idAtraccion1, Integer idAtraccion2, Integer idAtraccion3) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Promocion promocion;
		List <Atraccion> atracciones;
		if(precioFinal != 0) {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(0, atraccionDAO.find(idAtraccion1));
			atracciones.add(1, atraccionDAO.find(idAtraccion2));
			promocion = new PromocionFinal(id, nombre, atracciones, precioFinal);
			if (promocion.isValid()) {
				promocionDAO.update(promocion);
			}
			return promocion;
			}
		else if(descuento != 0) {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(0, atraccionDAO.find(idAtraccion1));
			atracciones.add(1, atraccionDAO.find(idAtraccion2));
			PromocionPorcentual promocionPorcen = new PromocionPorcentual(id, nombre, atracciones, descuento);
			if (promocionPorcen.isValid()) {
				promocionDAO.update(promocionPorcen);
			}
			return promocionPorcen;
		} else {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(0, atraccionDAO.find(idAtraccion1));
			atracciones.add(1, atraccionDAO.find(idAtraccion2));
			atracciones.add(2, atraccionDAO.find(idAtraccion3));
			promocion = new Promocion3x2(id, nombre, atracciones);
			if (promocion.isValid()) {
				promocionDAO.update(promocion);
			}
			return promocion;
			}
	}


	public void delete(Integer id) {
		Promocion promocion = new Promocion3x2(id);

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.delete(promocion);
	}

	public Promocion find(Integer id) {
		return DAOFactory.getPromocionDAO().find(id);
	}

}
