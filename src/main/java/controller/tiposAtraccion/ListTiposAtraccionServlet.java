package controller.tiposAtraccion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Attraction;
import model.TipoAtraccion;
import services.TipoAtraccionService;

@WebServlet("/tiposAtraccion/index.do")
public class ListTiposAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<TipoAtraccion> tiposAtraccion = tipoAtraccionService.list();
		req.setAttribute("tiposAtraccion", tiposAtraccion);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/tiposAtraccion/index.jsp");
		dispatcher.forward(req, resp);

	}

}
