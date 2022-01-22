package main;

public class Book {
	private String title;
	private float price;
	private int pageNumber;
	private Genres genre;

	public Book(String title, float price, int pageNumber, Genres genre) {
		super();
		this.title = title;
		this.price = price;
		this.pageNumber = pageNumber;
		this.genre = genre;
	}

	public Book() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Genres getGenre() {
		return genre;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", pageNumber=" + pageNumber + ", genre=" + genre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + pageNumber;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (genre != other.genre)
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
