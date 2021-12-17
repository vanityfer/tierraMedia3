package controller.atracciones;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/atracciones/edit.do")
public class EditAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService atraccionService;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		List <TipoAtraccion> tiposAtraccion = tipoAtraccionService.list();
		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccion", atraccion);
		req.setAttribute("tiposAtraccion", tiposAtraccion);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer tipo = Integer.parseInt(req.getParameter("tipo"));
		Integer precio = Integer.parseInt(req.getParameter("precio"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		
		TipoAtraccion tipoAtraccion = tipoAtraccionService.find(tipo);

		Atraccion atraccion = atraccionService.update(id, nombre, tipoAtraccion, precio, tiempo, cupo);

		if (atraccion.isValid()) {
			resp.sendRedirect("/turismo/atracciones/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/atracciones/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
