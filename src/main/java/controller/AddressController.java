package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressImp;
import dao.BookImp;
import dao.CustomerImp;
import model.Address;
import model.Book;
import model.Cart;
import model.Customer;

import model.User;

/**
 * Servlet implementation class AddressController
 */
@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerImp dao;
	private AddressImp addressDb;
	private BookImp bookDAO;

	public AddressController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		dao = new CustomerImp();
		addressDb = new AddressImp();
		bookDAO = new BookImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user_info");
		Customer customer = dao.getCustomerById(user.getUserid());
		
		Address address = addressDb.getAddressById(customer.getAddressId());
		if(address != null) {
			request.getSession().setAttribute("bAddress", address.getBilling());
			request.getSession().setAttribute("sAddress", address.getShipping());
		}
		request.getRequestDispatcher("addSBaddress.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String billingAddress = request.getParameter("bAddress");
		String shippingAddress = request.getParameter("sAddress");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		System.out.println("am address controller line ");
		List<Book> book = (List<Book>)cart.getBooks(); 
		
		List<Book> newList = new ArrayList<>();
		List<Book> outOfInventory = new ArrayList<>();
		
//		for(Book book:books) {
//			book = bookDAO.getBookById(book.getBookId());
//			if(book.getQuantity() > 0) {
//				book.setQuantity(book.getQuantity()-1);
//				newList.add(book);
//			}
//			else {
//				outOfInventory.add(book);
//			}
//		}
		
		if(outOfInventory.size() > 0) {
			StringBuilder strBuilder = new StringBuilder("The following item(s) couldn't be found in store:");
			outOfInventory.forEach(b -> strBuilder.append(b.getTitle() + "\n"));
			request.getSession().setAttribute("bAddress", billingAddress);
			request.getSession().setAttribute("sAddress", shippingAddress);
			
			request.getSession().setAttribute("store", strBuilder.toString());
			response.sendRedirect("addSBaddress.jsp");
		}
		else {
			for(Book abook:newList) {
				//bookDAO.updateBook(abook);
			}
			//cart.setBooks(newList);
			User user = (User) request.getSession().getAttribute("user_info");
			Customer customer = dao.getCustomerById(user.getUserid());
			
			Address address = new Address(shippingAddress, billingAddress);
			address = addressDb.addCustomerAddress(address);
			//address
			dao.updateCustomerAddress(customer, address);
	
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("customer", customer);
			request.getSession().setAttribute("address", address);
			

			response.sendRedirect("PaymentController");
		}
	}

}
