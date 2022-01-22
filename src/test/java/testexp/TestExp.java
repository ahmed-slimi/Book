package testexp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Book;
import main.BookISBN;
import main.Customer;
import main.Genres;
import main.Shop;

public class TestExp {
	Shop sh;
	Shop sh1;
	Shop sh2;
	Shop sh3;
	Customer c1;
	Customer c2;
	Book b3;
	Book b2;
	Book b1;
	Book b4;
	Book b5;
	BookISBN isbn1;
	BookISBN isbn4;

	@Before
	public void setUp() throws Exception {
		b1 = new Book("T1", 13.5f, 100, Genres.Adventure);
		b4 = new Book("T7", 13.5f, 100, Genres.Adventure);
		b2 = new Book("T2", 200f, 200, Genres.Adventure);
		b3 = new Book("T3", 8f, 2, Genres.Comic);
		b5 = new Book("T4", 8f, 20, Genres.Adventure);
		isbn1 = new BookISBN("T1", 13.5f, 100, Genres.Adventure, "978-3608963762");
		isbn4 = new BookISBN("T3", 8f, 2, Genres.Comic, "978-758245159");
		List<Book> bs = new ArrayList<Book>();
		List<Book> bs1 = new ArrayList<Book>();
		List<Book> bs2 = new ArrayList<Book>();
		List<Book> bs3 = new ArrayList<Book>();
		bs.add(b1);
		bs.add(b3);
		bs.add(b1);

		bs1.add(b1);
		bs1.add(b3);
		bs1.add(b1);

		bs2.add(b2);
		bs3.add(b3);

		List<Book> HamaBooks = new ArrayList<Book>();

		sh = new Shop("AliShop", bs, 0);
		sh1 = new Shop("MhrezShop", bs1, 0);
		sh2 = new Shop("Shop", bs2, 0);
		sh3 = new Shop("Shop1", bs3, 0);
		c1 = new Customer("Hamachrab", HamaBooks, 200);
		c2 = new Customer("Hamachrab", HamaBooks, 2);
	}

	@Test
	public void testBuy() {
		Assert.assertEquals("Book Not found", sh.Buy(b2, c1));
	}

	@Test
	public void testBuy1() {
		Assert.assertEquals("Buy sucess", sh.Buy(b3, c1));
	}

	@Test
	public void testBuy2() {
		Assert.assertEquals("You dont have enough money", sh.Buy(b3, c2));
	}

	@Test
	public void testFilter() {
		Assert.assertEquals(2, sh.Filter("Adventure").size());
	}

	@Test
	public void testRemoveDuplicates() {
		Assert.assertEquals(2, sh.RemoveDuplicates().size());
	}

	@Test
	public void testCompare() {
		Assert.assertEquals("The Stores have the same Books", c1.Compare(sh, sh1));
	}

	@Test
	public void testCompare1() {
		Assert.assertEquals("Not the same Books1", c1.Compare(sh, sh2));
	}

	@Test
	public void testCompare2() {
		Assert.assertEquals("Not the same Books", c1.Compare(sh2, sh3));
	}

	@Test
	public void testValidISBN13() {
		Assert.assertEquals(true, isbn1.ValidISBN13(isbn1));

	}

	@Test
	public void test1ValidISBN13() {
		Assert.assertEquals(false, isbn1.ValidISBN13(isbn4));

	}
}
