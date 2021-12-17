package controller.atracciones;
import java.io.IOException;
import java.util.Map;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.ComprarAtraccionService;


@WebServlet("/atracciones/buy.do")
public class ComprarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private ComprarAtraccionService comprarAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarAtraccionService = new ComprarAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer atraccionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = comprarAtraccionService.buy(usuario.getIdUsuario(), atraccionId);
		
		Usuario usuario2 = DAOFactory.getUsuarioDAO().find(usuario.getIdUsuario());
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errors.isEmpty()) {
			req.setAttribute("success", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/comprar/index.do");
		dispatcher.forward(req, resp);
	}
}