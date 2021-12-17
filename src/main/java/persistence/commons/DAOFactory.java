package persistence.commons;

import persistence.AtraccionDAO;
import persistence.AttractionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.TipoAtraccionDAO;
import persistence.UsuarioDAO;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionDAOImpl;
import persistence.impl.TipoAtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {

	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}
	
	public static TipoAtraccionDAO getTipoAtraccionDAO() {
		return new TipoAtraccionDAOImpl();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	}
	
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
	
}
