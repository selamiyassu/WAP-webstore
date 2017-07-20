package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookImp;
import model.Book;
import model.Cart;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookImp dao;
	
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		dao = new BookImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute("cart");

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Book book = dao.getBookById(bookId);
		cart.removeBook(book); // add to product Cart
		session.setAttribute("cart", cart);
		
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
	}

}
