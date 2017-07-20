package model;

import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String author;
	private Date year;
	private String type;
	private String image;
	private double price;
	private int category_id;
	
	public Book() {
		
	}
	public Book(String title, String author, Date year, String type, String image, double price,
			int category_id) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.type = type;
		this.image = image;
		this.price = price;
		this.category_id = category_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}	
	
}
