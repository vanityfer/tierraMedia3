package controller.tiposAtraccion;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoAtraccion;
import services.TipoAtraccionService;

@WebServlet("/tiposAtraccion/edit.do")
public class EditarTipoAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		TipoAtraccion tipoAtraccion = tipoAtraccionService.find(id);
		req.setAttribute("tipoAtraccion", tipoAtraccion);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/tiposAtraccion/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		TipoAtraccion tipoAtraccion = tipoAtraccionService.update(id, nombre);
		resp.sendRedirect("/turismo/tiposAtraccion/index.do");
		}
	}

