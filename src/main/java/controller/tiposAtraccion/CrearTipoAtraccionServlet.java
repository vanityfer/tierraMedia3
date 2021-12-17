package controller.tiposAtraccion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Attraction;
import model.TipoAtraccion;
import services.AtraccionService;
import services.TipoAtraccionService;

@WebServlet("/tiposAtraccion/create.do")
public class CrearTipoAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/tiposAtraccion/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");

		TipoAtraccion tipoAtraccion = tipoAtraccionService.create(nombre);
			resp.sendRedirect("/turismo/tiposAtraccion/index.do");
		
	}

}
