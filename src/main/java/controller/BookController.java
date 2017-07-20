package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookImp;
import model.Book;

@WebServlet("/BookController")
public class BookController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private BookImp bookDAO;
	public static final String LIST_BOOKS = "bookList.jsp";
	public static final String INSERT_OR_EDIT = "book.jsp";
	//public static final String CART = "cart.jsp";
	public static final String DETAIL = "bookDetail.jsp";

	@Override
	public void init() throws ServletException {
		bookDAO = new BookImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward;
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_BOOKS;
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			bookDAO.deleteBook(bookId);
			request.setAttribute("books", bookDAO.getAllBooks());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			Book book = bookDAO.getBookById(bookId);
			request.setAttribute("action", "edit");
			request.setAttribute("aBook", book);
		} else if (action.equalsIgnoreCase("insert")) {
			request.setAttribute("action", "insert");
			forward = INSERT_OR_EDIT;
		} else {
			forward = LIST_BOOKS;
			request.setAttribute("books", bookDAO.getAllBooks());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookTitle = request.getParameter("title");
		String bookAuthor = request.getParameter("author");
		Date bookYear = Date.valueOf(request.getParameter("year").trim());
		String bookType = request.getParameter("type");
		String bookImage = request.getParameter("image");
		double bookPrice = Double.parseDouble(request.getParameter("price"));
		int bookCategoryId = Integer.parseInt(request.getParameter("categoryId"));
		Book book = new Book(bookTitle, bookAuthor, bookYear, bookType, bookImage, bookPrice, bookCategoryId);
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("edit")) {
			bookDAO.updateBook(book);
		}
		else { 
			bookDAO.addBook(book);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_BOOKS);
		request.setAttribute("books", bookDAO.getAllBooks());
		view.forward(request, response);

	}
}
