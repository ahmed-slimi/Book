package main;

import java.util.List;

public class Customer {
	private String name;
	private List<Book> ownBooks;
	private float money;

	public Customer(String name, List<Book> ownBooks, float money) {
		super();
		this.name = name;
		this.ownBooks = ownBooks;
		this.money = money;
	}

	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getOwnBooks() {
		return ownBooks;
	}

	public void setOwnBooks(List<Book> ownBooks) {
		this.ownBooks = ownBooks;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ownBooks=" + ownBooks + ", money=" + money + "]";
	}

	public String Compare(Shop stor1, Shop stor2) {
		// stor1 without Duplicate
		List<Book> newstor1 = stor1.RemoveDuplicates();
		List<Book> newstor2 = stor2.RemoveDuplicates();

		if (newstor1.size() != newstor2.size())
			return "Not the same Books1";
		for (Book myData : newstor1) {
			if (!newstor2.contains(myData))
				return "Not the same Books";
		}
		for (Book myData : newstor2) {
			if (!newstor1.contains(myData))
				return "Not the same Books";
		}
		return "The Stores have the same Books";

	}

}
