package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import model.TipoAtraccion;
import model.Usuario;
import model.nullobjects.NullUsuario;
import persistence.AtraccionDAO;
import persistence.TipoAtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int updateUsuarios(List<Usuario> u1) {

		try {
			int rows = 0;
			String sql = "UPDATE usuarios SET presupuesto = ?, tiempo= ? WHERE id = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			for (Usuario usuarios : u1) {
				statement.setInt(1, usuarios.getPresupuesto());
				statement.setDouble(2, usuarios.getTiempoDisponible());
				statement.setInt(3, usuarios.getIdUsuario());
				 rows = statement.executeUpdate();
			}
			
			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET nombre = ?, contrasenia = ?, preferencia = ?, presupuesto = ?, tiempo= ? WHERE id = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getContrasenia());
			statement.setInt(3, usuario.getPreferencia().getID());
			statement.setInt(4, usuario.getPresupuesto());
			statement.setDouble(5, usuario.getTiempoDisponible());
			statement.setInt(6, usuario.getIdUsuario());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados) {
		try {
			TipoAtraccionDAO tipoAtraccDAO = DAOFactory.getTipoAtraccionDAO();
			TipoAtraccion tipoAtracc = tipoAtraccDAO.find(resultados.getInt(4));
			return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getString(3),tipoAtracc,
					resultados.getInt(5), resultados.getDouble(6), resultados.getBoolean(7));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		return 0;
	}

	public int insert(Usuario usuario) {
		try {
			String sql = "INSERT INTO USUARIOS (NOMBRE, CONTRASENIA, PREFERENCIA, PRESUPUESTO, TIEMPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getContrasenia());
			statement.setInt(3, usuario.getPreferencia().getID());
			statement.setInt(4, usuario.getPresupuesto());
			statement.setDouble(5, usuario.getTiempoDisponible());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Usuario usuario) {
		try {
			String sql = "DELETE FROM USUARIOS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, usuario.getIdUsuario());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = NullUsuario.build();

			if (resultados.next()) {
				usuario = toUsuario(resultados);
			}

			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM usuarios WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Usuario usuario = null;
			if(resultados.next()) {
				usuario = toUsuario(resultados);
			}
			
			return usuario;
			} catch(Exception e) {
				throw new MissingDataException(e);
			}
	}
}
