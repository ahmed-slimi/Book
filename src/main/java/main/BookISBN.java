package main;

public class BookISBN extends Book {
	private String isbn13;

	public BookISBN(String title, float price, int pageNumber, Genres genre) {
		super(title, price, pageNumber, genre);
	}

	public BookISBN(String title, float price, int pageNumber, Genres genre, String isbn13) {
		super(title, price, pageNumber, genre);
		this.isbn13 = isbn13;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}


	@Override
	public String toString() {
		return "BookISBN [isbn13=" + isbn13+ ", toString()=" + super.toString() +  "]";
	}

	public boolean ValidISBN13(BookISBN book) {
		if (book.getIsbn13().charAt(3) != '-' ||  book.getIsbn13().length() != 14) {
			return false;
		}
		String s1 = book.getIsbn13().replace("-", "");
		if (isNumeric(s1) ) {

			return true;
		}
		return false;

	}

	public static boolean isNumeric(String str) { 
		  for (char c : str.toCharArray())
		    {
		        if (!Character.isDigit(c)) 
		        	return false;
		    }
		    return true;
		}
}
