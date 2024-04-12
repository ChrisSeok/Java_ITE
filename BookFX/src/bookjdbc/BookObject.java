package bookjdbc;

public class BookObject {

	private String isbn;
	private String title;
	private int price;
	private String author;

	// 생성자
	public BookObject(String isbn, String title, int price, String author) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
