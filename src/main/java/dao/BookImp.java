package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconnection.ConnectionManager;
import model.Book;

public class BookImp {

	ConnectionManager dbm = new ConnectionManager();
	Connection con = dbm.getConnection();
	ArrayList<Book> bookDAO;

	public Book getBookById(int bookId) {

		Book book = new Book();
		try {

			ResultSet rs;

			PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM books WHERE id = ?");

			preparedStmt.setInt(1, bookId); // from setString
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				book.setId(Integer.parseInt(rs.getString(1)));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setYear(Date.valueOf(rs.getString(4)));
				book.setType(rs.getString(5));
				book.setImage(rs.getString(6));
				book.setPrice(Double.parseDouble(rs.getString(7)));
				book.setCategory_id(Integer.parseInt(rs.getString(1)));
			}
			return book;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Book> getAllBooks() {

		ArrayList<Book> bookDAOList = new ArrayList<Book>();
		try {
			ResultSet rs;
			PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM books");
			rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rs.getString(1)));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setYear(Date.valueOf(rs.getString(4)));
				book.setType(rs.getString(5));
				book.setImage(rs.getString(6));
				book.setPrice(Double.parseDouble(rs.getString(7)));
				book.setCategory_id(Integer.parseInt(rs.getString(1)));

				bookDAOList.add(book);
			}
			return bookDAOList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public boolean deleteBook(int bookId) {
		try {
			con.createStatement();
			PreparedStatement stmt = con.prepareStatement("Delete from books where id = ?");
			stmt.setInt(1, bookId);
			stmt.execute(); // con.close();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Book addBook(Book book) {
		System.out.println(book.getCategory_id());
		//book.setCategory_id(book.getCategory_id() ? book.getCategory_id() : 2);
		try {
			PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO books "
					+ "(title, author, year, type, image, price, category_id) VALUES(?,?,?,?,?,?,?)");

			preparedStmt.setString(1, book.getTitle());
			preparedStmt.setString(2, book.getAuthor());
			preparedStmt.setDate(3, (Date) book.getYear());
			preparedStmt.setString(4, book.getType());
			preparedStmt.setString(5, book.getImage());
			preparedStmt.setDouble(6, book.getPrice());
			preparedStmt.setInt(7, book.getCategory_id());
			preparedStmt.execute();

			return book;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Book updateBook(Book book) { //

		try {

			PreparedStatement preparedStmt = con.prepareStatement(
			"update books set id = ?, title = ?, author = ?, year = ?, type = ?, image = ?, price = ?, category_id = ? where id = ?");

			preparedStmt.setInt(1, book.getId());
			preparedStmt.setString(2, book.getTitle());
			preparedStmt.setString(3, book.getAuthor());
			preparedStmt.setDate(4, (Date) book.getYear());
			preparedStmt.setString(5, book.getType());
			preparedStmt.setString(6, book.getImage());
			preparedStmt.setDouble(7, book.getPrice());
			preparedStmt.setInt(8, book.getCategory_id());
			preparedStmt.setInt(9, book.getId());
			preparedStmt.execute();

			return book;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
}
