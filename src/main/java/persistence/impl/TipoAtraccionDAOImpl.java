package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.TipoAtraccion;
import persistence.TipoAtraccionDAO;
import persistence.commons.MissingDataException;
import persistence.commons.ConnectionProvider;

public class TipoAtraccionDAOImpl implements TipoAtraccionDAO {
	
	@Override
	public List<TipoAtraccion> findAll() {
		try {
		String sql = "SELECT * FROM tipos_atraccion";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		List<TipoAtraccion> tipoAtracciones = new LinkedList<TipoAtraccion>();
		while(resultados.next()) {
			tipoAtracciones.add(toTipoAtraccion(resultados));
		}
		return tipoAtracciones;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int update(TipoAtraccion tipoAtraccion) {
		try {
			String sql = "UPDATE tipos_atraccion SET NOMBRE = ?  WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipoAtraccion.getName());
			statement.setInt(2, tipoAtraccion.getID());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public TipoAtraccion find(Integer id){
		try {
		String sql ="SELECT * FROM tipos_atraccion WHERE ID = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();
		TipoAtraccion tipoAtraccion = null;
		if(resultados.next()) {
			tipoAtraccion = toTipoAtraccion(resultados);
		}
		
		return tipoAtraccion;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int countAll() {
		return 0;
	}
	
	
	@Override
	public int insert(TipoAtraccion tipoAtraccion) {
		try {
			String sql = "INSERT INTO tipos_atraccion (NOMBRE) VALUES (?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipoAtraccion.getName());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}


	@Override
	public int delete(TipoAtraccion tipoAtraccion) {
		try {
			String sql = "DELETE FROM tipos_atraccion WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tipoAtraccion.getID());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private TipoAtraccion toTipoAtraccion(ResultSet resultados) {
		try {
		return new TipoAtraccion(resultados.getInt(1), resultados.getString(2));
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
}