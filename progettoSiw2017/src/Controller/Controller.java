package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Opera;
import validator.OperaValidator;
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String nextPage="/index.jsp";
		
		String _nomeutente =request.getParameter("txtusername");
		String _password =request.getParameter("txtpassword");
		try{
			if(_nomeutente!=null ){
				if(_nomeutente.equals("Sorin") && _password.equals("12345")){
					response.sendRedirect("operainsert.jsp");
				}
				else{
					response.sendError(404,"Autenticazione fallita! Riprovare di nuovo");
				}
			}
			
			
		}catch(Exception ex)
		{
			System.out.println("Errore :"+ex.getMessage());
		}
		
		
		
//		Opera opera=new Opera();
//		OperaValidator validator=new OperaValidator();
//		if(validator.validate(request)){
//		Long id=Long.parseLong(request.getParameter("id"));
//		
//			
//		}
//	
//	
//	
//		ServletContext application = getServletContext();
//		RequestDispatcher rd=application.getRequestDispatcher(nextPage);
//		rd.forward(request, response);
//		return;
		
	
	}

	
	
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
