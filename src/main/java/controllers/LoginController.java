package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.UserHelper;
import pojos.User;
import utilites.PasswordService;

@WebServlet(description = "A controller for handling uder logins", urlPatterns=("/Login")) 
public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String url;
	private int loginAttempts;
	
	/*public LoginController(){
		super();
	}*/



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		session = request.getSession();
		if (session.getAttribute("loginAttempts") == null){
			loginAttempts = 0;
		}
		
		if(loginAttempts >2){
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			request.setAttribute("errorMessage", errorMessage);
			url = "index.jsp";
		}else{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			PasswordService pws = new PasswordService();
			String encryptedPass = pws.encrypt(password);
			
			UserHelper uh = new UserHelper();
			User user = uh.authenticateUser(username, encryptedPass);	
		if(user != null){
			session.invalidate();
			session=request.getSession(true);
			session.setAttribute("user", user);
			url="UserAccount.jsp";
		}else{
			String errorMessage = "Error: Unrecognized Username or Password<br>Login attempts remaining: " + (3-(loginAttempts));
			request.setAttribute("errorMessage", errorMessage);
			session.setAttribute("loginAttempts", loginAttempts++);
			url = "index.jsp";
		}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	public void logout(){
		session.invalidate();
	}
	
}
