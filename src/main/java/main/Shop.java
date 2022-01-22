package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Shop {
	private String name;
	private List<Book> books;
	private float sales;

	public Shop(String name, List<Book> books, float sales) {
		super();
		this.name = name;
		this.books = books;
		this.sales = sales;
	}

	public Shop() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public float getSales() {
		return sales;
	}

	public void setSales(float sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", books=" + books + ", sales=" + sales + "]";
	}

	public String Buy(Book book, Customer customer) {

		for (Book b : books) {
			if (b.equals(book)) {
				if (customer.getMoney() > book.getPrice()) {
					customer.setMoney(customer.getMoney() - book.getPrice());
					setSales(getSales() + book.getPrice());
					customer.getOwnBooks().add(book);
					books.remove(book);
					return "Buy sucess";
	
				} else
					return "You dont have enough money";
			}
		}
		return "Book Not found";
	}

	public List<Book> Filter(String genre) {
		List<Book> bs = new ArrayList<Book>();
		for (Book b : books) {
			if (b.getGenre().toString() == genre) {
				bs.add(b);
			}
		}
		return bs;
	}

	public List<Book> RemoveDuplicates() {
		
		List<Book> newList = new ArrayList<Book>();

		// Traverse through the first list
		for (Book element : books) {
		
			// If this element is not present in newList
			// then add it
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}

		return newList;
		
	}
}
