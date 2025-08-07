import java.util.Objects;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private boolean isAvailable;

	public Book(int bookId, String title, String author, boolean isAvailable) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable
				+ "]";
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
		return Objects.equals(author, other.author) && bookId == other.bookId && isAvailable == other.isAvailable
				&& Objects.equals(title, other.title);
	}

}
