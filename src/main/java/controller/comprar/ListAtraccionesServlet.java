package controller.comprar;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Atraccion;
import model.Attraction;
import model.Promocion;
import model.Usuario;
import services.AtraccionService;
import services.PromocionService;
import services.UsuarioService;

@WebServlet("/comprar/index.do")
public class ListAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private AtraccionService atraccionService;
	private PromocionService promocionService;
	private UsuarioService usuarioService;
	private Administrador adm;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
		this.usuarioService = new UsuarioService();
		this.adm = new Administrador();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		List<Atraccion> atracciones = atraccionService.list();
		List<Promocion> promociones = promocionService.list();
		adm.agregarTodasAtracciones(atracciones);
		adm.agregarTodasPromociones(promociones);
		List <Atraccion> atraccionesIgual = adm.listarAtraccionesIgualPreferencia(usuario);
		List <Atraccion> atraccionesDistinta = adm.listarAtraccionesDistintaPreferencia(usuario);
		List <Promocion> promocionesIgual = adm.listarPromocionesIgualPreferencia(usuario);
		List <Promocion> promocionesDistinta = adm.listarPromocionesDistintaPreferencia(usuario);
		req.setAttribute("atraccionesIgual", atraccionesIgual);
		req.setAttribute("atraccionesDistinta", atraccionesDistinta);
		req.setAttribute("promocionesIgual", promocionesIgual);
		req.setAttribute("promocionesDistinta", promocionesDistinta);
	
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/comprar/index.jsp");
		dispatcher.forward(req, resp);

	}

}
