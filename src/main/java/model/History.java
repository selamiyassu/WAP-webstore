package model;

import java.util.List;

public class History {
	private String date;
	private List<Book> books;
	private String shippingAddress;
	private String billingAddress;
	private String paymentInfo;
	private String userName;
	
	public History(){		
	}
	
	public History(String date, List<Book> books, String shippingAddress, String billingAddress,
			String paymentInfo, String userName) {
		this.date = date;
		this.books = books;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.paymentInfo = paymentInfo;
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setProducts(List<Book> books) {
		this.books = books;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
