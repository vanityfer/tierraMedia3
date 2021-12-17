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
import model.Promocion3x2;
import model.PromocionFinal;
import model.PromocionPorcentual;
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/promociones/edit.do")
public class EditarPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
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
		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Atraccion> atracciones = atraccionService.list();
		Promocion promocion = promocionService.find(id);
		if (promocion instanceof PromocionFinal) {
			PromocionFinal promocionFinal = (PromocionFinal) promocion;
			req.setAttribute("promocionFinal", promocionFinal);
		} else if (promocion instanceof PromocionPorcentual) {
			PromocionPorcentual promoPorcentual = (PromocionPorcentual) promocion;
			req.setAttribute("promocionPorcentual", promoPorcentual);
		} else {
			System.out.println("Entre al if de promo 3x2");
			Promocion3x2 promo3x2 = (Promocion3x2) promocion;
			req.setAttribute("promocion3x2", promo3x2);
		}

		req.setAttribute("atracciones", atracciones);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String precioFinalString = req.getParameter("precioFinal");
		String descuentoString = req.getParameter("porcentaje");
		Integer idAtraccion1 = Integer.parseInt(req.getParameter("atraccion1"));
		Integer idAtraccion2 = Integer.parseInt(req.getParameter("atraccion2"));
		Promocion promocion;
		if(precioFinalString != null) {
			Integer precioFinal = Integer.parseInt(precioFinalString);
			promocion = promocionService.update(id, nombre, precioFinal, 0, idAtraccion1, idAtraccion2, 0);
			}
		else if(descuentoString != null) {
			Integer descuento = Integer.parseInt(descuentoString);
			promocion = promocionService.update(id, nombre, 0, descuento, idAtraccion1, idAtraccion2, 0);
			}
		else {
			Integer idAtraccion3 = Integer.parseInt(req.getParameter("atraccion3"));
			promocion = promocionService.update(id, nombre, 0, 0, idAtraccion1, idAtraccion2, idAtraccion3);
			}
		if (promocion.isValid()) {
			resp.sendRedirect("/turismo/promociones/index.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/promociones/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
