import java.util.ArrayList;

public class User {

	private int userId;
	private String name;
	private ArrayList<Book> borrowedBooks;

	public User(int userId, String name) {
		this.userId = userId;
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
	}

	public String toString() {
		return userId + " - " + name;
	}
}
