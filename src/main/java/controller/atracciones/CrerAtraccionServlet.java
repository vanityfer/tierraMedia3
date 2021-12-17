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
import model.TipoAtraccion;
import services.AtraccionService;
import services.TipoAtraccionService;

@WebServlet("/atracciones/create.do")
public class CrerAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
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
		List <TipoAtraccion> tiposAtraccion = tipoAtraccionService.list();
		req.setAttribute("tiposAtraccion", tiposAtraccion);
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer tipo = Integer.parseInt(req.getParameter("tipo"));
		Integer precio = Integer.parseInt(req.getParameter("precio"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		
		TipoAtraccion tipoAtraccion = tipoAtraccionService.find(tipo);

		Atraccion atraccion = atraccionService.create(nombre, tipoAtraccion, precio, tiempo, cupo);
		
		if (atraccion.isValid()) {
			resp.sendRedirect("/turismo/atracciones/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/atracciones/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
