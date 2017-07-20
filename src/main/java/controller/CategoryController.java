package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryImp;
import model.Category;

@WebServlet("/categoryController")
public class CategoryController extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private CategoryImp categoryDAO;
	public static final String LIST_CATEGORY = "categoryList.jsp";
	public static final String INSERT_OR_EDIT = "category.jsp";
	//public static final String CART = "cart.jsp";
	public static final String DETAIL = "categoryDetail.jsp";

	@Override
	public void init() throws ServletException {
		categoryDAO = new CategoryImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward;
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_CATEGORY;
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			categoryDAO.deleteCategory(categoryId);
			request.setAttribute("categorys", categoryDAO.getAllCategory());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			Category category = categoryDAO.getCategoryById(categoryId);
			request.setAttribute("action", "edit");
			request.setAttribute("edCategory", category);
		} else if (action.equalsIgnoreCase("insert")) {
			request.setAttribute("action", "insert");
			forward = INSERT_OR_EDIT;
		} else {
			forward = LIST_CATEGORY;
			request.setAttribute("categories", categoryDAO.getAllCategory());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryId = request.getParameter("id");
		String categoryName = request.getParameter("name");
		
		Category category = new Category(categoryName);
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("edit")) {
			categoryDAO.updateCategory(category);
		}
		else { 
			categoryDAO.addCategory(category);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_CATEGORY);
		request.setAttribute("categories", categoryDAO.getAllCategory());
		view.forward(request, response);

	}
}

