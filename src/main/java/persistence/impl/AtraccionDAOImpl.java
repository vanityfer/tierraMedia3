package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Atraccion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.TipoAtraccionDAO;
import persistence.commons.MissingDataException;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;


public class AtraccionDAOImpl implements AtraccionDAO {
	
	@Override
	public List<Atraccion> findAll() {
		try {
		String sql = "SELECT * FROM atracciones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		while(resultados.next()) {
			atracciones.add(toAtraccion(resultados));
		}
		return atracciones;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int updateAtracciones(List<Atraccion> a1) {
		try {
			int rows = 0;
			String sql = "UPDATE atracciones SET cupo = ? WHERE id_atraccion = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			for (Atraccion atracciones : a1) {
				statement.setInt(1, atracciones.getCupo());
				statement.setInt(2, atracciones.getIdAtraccion());
				
				 rows = statement.executeUpdate();
			}
			
			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}
	
	@Override
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE ATRACCIONES SET NOMBRE = ?, TIPO = ?, COSTO = ?, CUPO = ?, TIEMPO = ?  WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getTipo().getID());
			statement.setInt(3, atraccion.getPrecio());
			statement.setInt(4, atraccion.getCupo());
			statement.setDouble(5, atraccion.getTiempo());
			statement.setInt(6, atraccion.getIdAtraccion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Atraccion toAtraccion(ResultSet resultados) {
		try {
		TipoAtraccionDAO tipoAtraccDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tipoAtracc = tipoAtraccDAO.find(resultados.getInt(3));
		return new Atraccion(resultados.getInt(1), resultados.getString(2), tipoAtracc, 
				resultados.getInt(4), resultados.getInt(5), resultados.getDouble(6));
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		return 0;
	}

	@Override
	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO ATRACCIONES (NOMBRE, TIPO, COSTO, CUPO, TIEMPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getTipo().getID());
			statement.setInt(3, atraccion.getPrecio());
			statement.setInt(4, atraccion.getCupo());
			statement.setDouble(5, atraccion.getTiempo());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion atraccion) {
		try {
			String sql = "DELETE FROM ATRACCIONES WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getIdAtraccion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	@Override
	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM atracciones WHERE id_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Atraccion atraccion = null;
			if(resultados.next()) {
				atraccion = toAtraccion(resultados);
			}
			
			return atraccion;
			} catch(Exception e) {
				throw new MissingDataException(e);
			}
		}
	}
