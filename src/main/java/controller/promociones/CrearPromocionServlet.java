package controller.promociones;

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
import model.Promocion;
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/promociones/create.do")
public class CrearPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private PromocionService promocionService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Atraccion> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String precioFinalString = req.getParameter("precioFinal");
		String descuentoString = req.getParameter("porcentaje");
		Integer idAtraccion1 = Integer.parseInt(req.getParameter("atraccion1"));
		Integer idAtraccion2 = Integer.parseInt(req.getParameter("atraccion2"));
		Promocion promocion;
		if(precioFinalString != null) {
			Integer precioFinal = Integer.parseInt(precioFinalString);
			promocion = promocionService.create(nombre, precioFinal, 0, idAtraccion1, idAtraccion2, 0);
			}
		else if(descuentoString != null) {
			Integer descuento = Integer.parseInt(descuentoString);
			promocion = promocionService.create(nombre, 0, descuento, idAtraccion1, idAtraccion2, 0);
			}
		else {
			Integer idAtraccion3 = Integer.parseInt(req.getParameter("atraccion3"));
			promocion = promocionService.create(nombre, 0, 0, idAtraccion1, idAtraccion2, idAtraccion3);
			}
		
		if (promocion.isValid()) {
			resp.sendRedirect("/turismo/promociones/index.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/promociones/create.jsp");
			dispatcher.forward(req, resp);
		}
	}
	}


