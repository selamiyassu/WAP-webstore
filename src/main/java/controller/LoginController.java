package controller;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserImp;
import model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserImp userDb;
	
	@Override
	public void init() throws ServletException {
		userDb = new UserImp();
	}
    public LoginController() {}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_info") == null)
			request.getRequestDispatcher("login.jsp").forward(request, response);
		else
			response.sendRedirect("CartController");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		String un = request.getParameter("user_name").trim();
		String pw = request.getParameter("pass").trim();
		String remember = request.getParameter("remember");
		String loginType; //= request.getParameter("logintype");
		
		try{
		User user=userDb.getUserByName(un);

		if (user.getUsername().trim().equals(un) && user.getPassword().trim().equals(pw)) {
			loginType = user.isAdmin() ? "admin" : "user";
			if(loginType.equalsIgnoreCase("admin")) {
				if(user.isAdmin()){
					request.getSession().setAttribute("userName", user.getUsername());
					request.getSession().setAttribute("user_info", user);
					request.getSession().setAttribute("admin", "admin");
							
					response.sendRedirect("BookController?action=list");
				}
				else{
					request.setAttribute("err_msg", "Unauthorized user.");
					response.sendRedirect("adminlogin.jsp");								
				}
			}
			else {
				request.getSession().setAttribute("userName", user.getUsername());
				request.getSession().setAttribute("user_info", user);
				
				if("on".equals(remember)){
					Cookie cookie= new Cookie("user",user.getUsername());
					cookie.setMaxAge(7*24*60*60);
					response.addCookie(cookie);
				}else{
					Cookie cookie= new Cookie("user", null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				response.sendRedirect("CartController");
			}
			}
			}
			catch (Exception e) {
				e.printStackTrace();
				request.getSession().setAttribute("user_info", null);
				request.setAttribute("err_msg", "Username and/or password invalid.");
				doGet(request, response);

			}
		}

	}
