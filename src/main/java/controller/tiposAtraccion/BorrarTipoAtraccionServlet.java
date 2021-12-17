package controller.tiposAtraccion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;
import services.TipoAtraccionService;

@WebServlet("/tiposAtraccion/delete.do")
public class BorrarTipoAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		tipoAtraccionService.delete(id);

		resp.sendRedirect("/turismo/tiposAtraccion/index.do");
	}


}
