package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import persistence.commons.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.Promocion3x2;
import model.PromocionFinal;
import model.PromocionPorcentual;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {

	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Promocion promocion) {
		try {
			String sql;
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement;
			if (promocion instanceof PromocionFinal) {
				sql = "UPDATE PROMOCIONES SET NOMBRE = ?, TIPO = ?, ATRACCION_1 = ?, ATRACCION_2 = ?, PRECIO_REAL = ?, PRECIO_FINAL = ? WHERE ID_PROMOCION = ?";
				statement = conn.prepareStatement(sql);
				statement.setString(1, promocion.getNombre());
				statement.setInt(2, promocion.getTipoPromocion().getID());
				statement.setInt(3, promocion.getAtracciones().get(0).getIdAtraccion());
				statement.setInt(4, promocion.getAtracciones().get(1).getIdAtraccion());
				statement.setInt(5, promocion.getCosto());
				statement.setInt(6, promocion.getPrecioFinal());
				statement.setInt(7, promocion.getPromocionId());
			} else if (promocion instanceof PromocionPorcentual) {
				PromocionPorcentual promoPorcentual = (PromocionPorcentual) promocion;
				sql = "UPDATE PROMOCIONES SET NOMBRE = ?, TIPO = ?, ATRACCION_1 = ?, ATRACCION_2 = ?, PRECIO_REAL = ?, PRECIO_FINAL = ?, DESCUENTO = ? WHERE ID_PROMOCION = ?";
				statement = conn.prepareStatement(sql);
				statement.setString(1, promoPorcentual.getNombre());
				statement.setInt(2, promoPorcentual.getTipoPromocion().getID());
				statement.setInt(3, promoPorcentual.getAtracciones().get(0).getIdAtraccion());
				statement.setInt(4, promoPorcentual.getAtracciones().get(1).getIdAtraccion());
				statement.setInt(5, promoPorcentual.getCosto());
				statement.setInt(6, promoPorcentual.getPrecioFinal());
				statement.setInt(7, promoPorcentual.getPorcentajePromo());
				statement.setInt(8, promoPorcentual.getPromocionId());
			} else {
				sql = "UPDATE PROMOCIONES SET NOMBRE = ?, TIPO = ?, ATRACCION_1 = ?, ATRACCION_2 = ?, ATRACCION_3 = ?, PRECIO_REAL = ?, PRECIO_FINAL = ? WHERE ID_PROMOCION = ?";
				statement = conn.prepareStatement(sql);
				statement.setString(1, promocion.getNombre());
				statement.setInt(2, promocion.getTipoPromocion().getID());
				statement.setInt(3, promocion.getAtracciones().get(0).getIdAtraccion());
				statement.setInt(4, promocion.getAtracciones().get(1).getIdAtraccion());
				statement.setInt(5, promocion.getAtracciones().get(2).getIdAtraccion());
				statement.setInt(6, promocion.getCosto());
				statement.setInt(7, promocion.getPrecioFinal());
				statement.setInt(8, promocion.getPromocionId());
			}
			int rows = statement.executeUpdate();
			return rows;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	private Promocion toPromocion(ResultSet resultados) {
		try {
			AtraccionDAO atraccDAO = DAOFactory.getAtraccionDAO();
			List<Atraccion> atracciones;
			if (resultados.getString(6) != null) {
				atracciones = new ArrayList<Atraccion>();
				atracciones.add(atraccDAO.find(resultados.getInt(4)));
				atracciones.add(atraccDAO.find(resultados.getInt(5)));
				atracciones.add(atraccDAO.find(resultados.getInt(6)));
				return new Promocion3x2(resultados.getInt(1), resultados.getString(2), atracciones);
			} else if (resultados.getString(9) != null) {
				atracciones = new ArrayList<Atraccion>();
				atracciones.add(atraccDAO.find(resultados.getInt(4)));
				atracciones.add(atraccDAO.find(resultados.getInt(5)));
				return new PromocionPorcentual(resultados.getInt(1), resultados.getString(2), atracciones,
						resultados.getInt(9));
			} else {
				atracciones = new ArrayList<Atraccion>();
				atracciones.add(atraccDAO.find(resultados.getInt(4)));
				atracciones.add(atraccDAO.find(resultados.getInt(5)));
				return new PromocionFinal(resultados.getInt(1), resultados.getString(2), atracciones,
						resultados.getInt(8));
			}
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		return 0;
	}

	public int insert(Promocion promocion) {
		try {
			String sql;
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement;
			if (promocion instanceof PromocionFinal) {
				sql = "INSERT INTO promociones (NOMBRE, TIPO, ATRACCION_1, ATRACCION_2, PRECIO_REAL, PRECIO_FINAL) VALUES (?, ?, ?, ?, ?, ?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, promocion.getNombre());
				statement.setInt(2, promocion.getTipoPromocion().getID());
				statement.setInt(3, promocion.getAtracciones().get(0).getIdAtraccion());
				statement.setInt(4, promocion.getAtracciones().get(1).getIdAtraccion());
				statement.setInt(5, promocion.getCosto());
				statement.setInt(6, promocion.getPrecioFinal());
			} else if (promocion instanceof PromocionPorcentual) {
				PromocionPorcentual promoPorcentual = (PromocionPorcentual) promocion;
				sql = "INSERT INTO promociones (NOMBRE, TIPO, ATRACCION_1, ATRACCION_2, PRECIO_REAL, PRECIO_FINAL, DESCUENTO) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, promoPorcentual.getNombre());
				statement.setInt(2, promocion.getTipoPromocion().getID());
				statement.setInt(3, promoPorcentual.getAtracciones().get(0).getIdAtraccion());
				statement.setInt(4, promoPorcentual.getAtracciones().get(1).getIdAtraccion());
				statement.setInt(5, promoPorcentual.getCosto());
				statement.setInt(6, promoPorcentual.getPrecioFinal());
				statement.setInt(7, promoPorcentual.getPorcentajePromo());
			} else {
				sql = "INSERT INTO promociones (NOMBRE, TIPO, ATRACCION_1, ATRACCION_2, ATRACCION_3, PRECIO_REAL, PRECIO_FINAL) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, promocion.getNombre());
				statement.setInt(2, promocion.getTipoPromocion().getID());
				statement.setInt(3, promocion.getAtracciones().get(0).getIdAtraccion());
				statement.setInt(4, promocion.getAtracciones().get(1).getIdAtraccion());
				statement.setInt(5, promocion.getAtracciones().get(2).getIdAtraccion());
				statement.setInt(6, promocion.getCosto());
				statement.setInt(7, promocion.getPrecioFinal());
			}
			int rows = statement.executeUpdate();
			return rows;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Promocion promocion) {
		try {
			String sql = "DELETE FROM PROMOCIONES WHERE ID_PROMOCION = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promocion.getPromocionId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Promocion findByPromocionName(String name) {
		return null;
	}


	@Override
	public Promocion find(Integer id) {
		try {
			String sql = "SELECT * FROM promociones WHERE id_promocion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Promocion promocion = null;
			if(resultados.next()) {
				promocion = toPromocion(resultados);
			}
			return promocion;
			} catch(Exception e) {
				throw new MissingDataException(e);
			}
		}
}
