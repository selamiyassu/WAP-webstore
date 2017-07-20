package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.BookImp;
import dao.CategoryImp;
import model.Book;
import model.Cart;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookImp dbm;  
	private CategoryImp cbm;
    public HomeController() { super();}
    
    @Override
    public void init() throws ServletException {
    	dbm = new BookImp();
    	cbm = new CategoryImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Cart cart;
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("cart") == null) {
			cart = new Cart(null, new ArrayList<>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}
		if (action.equalsIgnoreCase("addToCart")) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			Book book = dbm.getBookById(bookId);
			cart.addBook(book);
			session.setAttribute("cart", cart);
			System.out.println("Book Name In Cart:" + cart.getBooks().get(0).getTitle());
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}	
		else if(action.equalsIgnoreCase("reset")){
			session.setAttribute("cart", null);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
		else{
			doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("listBooks")) {
			PrintWriter out = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dbm.getAllBooks());
		    response.setContentType("text/json");
		    response.setCharacterEncoding("UTF-8");
	
		    out.write(json);
		    out.close();
		}else {
			PrintWriter out = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(cbm.getAllCategory());
		    response.setContentType("text/json");
		    response.setCharacterEncoding("UTF-8");
	
		    out.write(json);
		    out.close();
		}
	}

}
