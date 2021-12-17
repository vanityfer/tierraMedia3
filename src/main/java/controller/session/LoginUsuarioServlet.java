package controller.session;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.LoginUsuariosService;

@WebServlet("/loginUsuarios")
public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 8308079314140233763L;
	private LoginUsuariosService loginUsuariosService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginUsuariosService = new LoginUsuariosService();
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nombreUsuario = req.getParameter("nombreUsuario");
    	String contrasenia = req.getParameter("contrasenia");
    	
    	Usuario usuario = loginUsuariosService.login(nombreUsuario, contrasenia);
    	
    	if (!usuario.isNull()) {
    		req.getSession().setAttribute("usuario", usuario);
    		resp.sendRedirect("index.jsp");    		
       	} else {
    		req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/loginUsuarios.jsp");
      		    dispatcher.forward(req, resp);
    	}
    }
}
