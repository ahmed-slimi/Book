package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

	public static void main(String[] args) {
		Book b1 = new Book("T1", 13.5f, 100, Genres.Adventure);
		Book b4 = new Book("T7", 13.5f, 100, Genres.Adventure);
		Book b2 = new Book("T2", 200f, 200, Genres.Adventure);
		Book b3 = new Book("T3", 8f, 2, Genres.Comic);
		Book b5 = new Book("T4", 8f, 20, Genres.Adventure);

		BookISBN isbn1 = new BookISBN("T1", 13.5f, 100, Genres.Adventure, "978-3608963762");
		BookISBN isbn2 = new BookISBN("T7", 13.5f, 100, Genres.Adventure, "978-3442267747");
		BookISBN isbn3 = new BookISBN("T2", 200f, 200, Genres.Adventure, "978-758245159");
		BookISBN isbn4 = new BookISBN("T3", 8f, 2, Genres.Comic, "978-3841335180");
		BookISBN isbn5 = new BookISBN("T4", 8f, 20, Genres.Adventure, "978-3442267819");
		List<Book> bs = new ArrayList<Book>();
		bs.add(b1);
		bs.add(b2);
		bs.add(b3);
		List<Book> bs1 = new ArrayList<Book>();
		bs1.add(b1);
		bs.add(b1);
		bs.add(b1);
		bs.add(b1);
		bs.add(b1);

		////////// Add books ISBN ///////////////
		List<Book> bs5 = new ArrayList<Book>();
		System.out.println(" bs5 = " + bs5);
		Shop sh5 = new Shop("AliShop", bs5, 0);

		ArrayList<BookISBN> arrayList = new ArrayList<BookISBN>(Arrays.asList(isbn1, isbn2, isbn3, isbn4, isbn5));
		for (BookISBN b : arrayList) {
			if (b.ValidISBN13(b)) {
				System.out.println("valid");
				bs5.add(b);
			} else
				System.out.println("Notvalid");

		}
		System.out.println("New bs5 = " + bs5 + "\n");
		System.out.println(sh5 + "\n");

		List<Book> HamaBooks = new ArrayList<Book>();

		Shop sh = new Shop("AliShop", bs, 0);
		Shop sh1 = new Shop("MhrezShop", bs1, 0);
		Customer c1 = new Customer("Hamachrab", HamaBooks, 200);
		///////// Comparison//////////
		System.out.println(c1.Compare(sh, sh1));

		System.out.println(sh.toString());
		System.out.println(c1.toString());
		///////// Filtering of books////////
		System.out.println(sh.Filter("Adventure"));
		////////// Remove duplicates///////////////
		System.out.println(sh.RemoveDuplicates());

		/////////// Sale of a certain book from a store to a
		/////////// customer//////////////
		System.out.println(sh.Buy(b3, c1));
		System.out.println(sh.toString());
		System.out.println(c1.toString());
		/////////// Sale of a certain book from a store to a
		/////////// customer//////////////
		System.out.println(sh.Buy(b3, c1));

	}

}
