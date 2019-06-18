package com.cds.controller;
/*mod*/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//https://www.galisteocantero.com/sesiones-en-servlets-y-jsp-ejemplo-login-logout/
//https://www.youtube.com/watch?v=_1HHUJOfoTY
/**
 * Servlet implementation class Sesions
 */
@WebServlet(urlPatterns = {"/login", "/wellcome"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    /**
     * @see HttpServlet#HttpServlet()
    */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action =  " ";
		
		if(request.getParameter("action") != null){
			action = request.getParameter("action");
		}
		
        HttpSession sesion = request.getSession();
        
        if(action.equals("out")){
        	//Destruir sesion
            sesion.invalidate();
                                      //Url Principal del proyecto  
            request.getRequestDispatcher("login.jsp").forward(request, response);
           // response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
        	 //Redireccionar a login
        	 request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession sesion = request.getSession();
	        String usu, pass;
	        usu = request.getParameter("user");
	        pass = request.getParameter("password");
	        //deber�amos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo c�digo
	        if(usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
	            //si coincide usuario y password y adem�s no hay sesi�n iniciada
	            sesion.setAttribute("usuario", usu);
	            //redirijo a p�gina con informaci�n de login exitos
	             response.sendRedirect("welcome.jsp");
	        }else{
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	}

}
