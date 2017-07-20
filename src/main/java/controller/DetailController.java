package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookImp;
import model.Book;

@WebServlet("/BookDetail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookImp dbm;
	  
  
    public DetailController() {super();}

    @Override
    public void init() throws ServletException {
    	dbm = new BookImp();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Book book = dbm.getBookById(bookId);
		request.getSession().setAttribute("book", book);
		System.out.println(book.getTitle());
		
		request.getRequestDispatcher("bookDetail.jsp").forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
