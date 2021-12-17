package controller.usuarios;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoAtraccion;
import model.Usuario;
import services.TipoAtraccionService;
import services.UsuarioService;

@WebServlet("/usuarios/create.do")
public class CrearUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UsuarioService usuarioService;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <TipoAtraccion> tiposAtraccion = tipoAtraccionService.list();
		req.setAttribute("tiposAtraccion", tiposAtraccion);
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String contrasenia = req.getParameter("contrasenia");
		Integer preferencia = Integer.parseInt(req.getParameter("preferencia"));
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		TipoAtraccion tipoAtraccion = tipoAtraccionService.find(preferencia);
		
		Usuario tmp_usuario = usuarioService.create(nombre, contrasenia, tipoAtraccion, presupuesto, tiempoDisponible);
		
		if (tmp_usuario.isValid()) {
			resp.sendRedirect("/turismo/usuarios/index.do");
		} else {
			req.setAttribute("tmp_usuario", tmp_usuario);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuarios/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
