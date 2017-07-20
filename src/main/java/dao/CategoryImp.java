package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconnection.ConnectionManager;
import model.Book;
import model.Category;

public class CategoryImp {

	ConnectionManager dbm = new ConnectionManager();
	Connection con = dbm.getConnection();
	ArrayList<Category> bookDAO;

	public Category getCategoryById(int categoryId) {

		Category category = new Category();
		try {

			ResultSet rs;

			PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM category WHERE id = ?");

			preparedStmt.setInt(1, categoryId); // from setString
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				category.setId(Integer.parseInt(rs.getString(1)));
				category.setName(rs.getString(2));

			}
			return category;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Category> getAllCategory() {

		ArrayList<Category> categoryDAOList = new ArrayList<Category>();
		try {
			ResultSet rs;
			PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM category");
			rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(Integer.parseInt(rs.getString(1)));
				category.setName(rs.getString(2));

				categoryDAOList.add(category);
			}
			return categoryDAOList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public boolean deleteCategory(int categoryId) {
		try {
			con.createStatement();
			PreparedStatement stmt = con.prepareStatement("delete from category where pid = ?");
			stmt.setInt(1, categoryId);
			stmt.execute(); // con.close();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Category addCategory(Category category) {

		try {
			PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO category " + "(name) VALUES(?)");

			preparedStmt.setString(1, category.getName());
			preparedStmt.execute();

			return category;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Category updateCategory(Category category) { //

		try {

			PreparedStatement preparedStmt = con.prepareStatement("update Category set name = ? where id = ?");

			preparedStmt.setInt(1, category.getId());
			preparedStmt.setString(2, category.getName());

			preparedStmt.execute();

			return category;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
}
