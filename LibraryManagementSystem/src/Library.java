import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public void registerUser(User user) {
		users.add(user);
	}

	public Book findBookById(int id) {
		for (Book book : books) {
			if (book.getBookId() == id)
				return book;
		}
		return null;
	}

	public User findUserById(int id) {
		for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}

	public void issueBook(int userId, int bookId) {
	    User user = findUserById(userId);
	    Book book = findBookById(bookId);

	    if (user == null) {
	        System.out.println(" User not found.");
	        return;
	    }
	    if (book == null) {
	        System.out.println(" Book not found.");
	        return;
	    }

	    if (!book.isAvailable()) {
	        System.out.println(" Book is already issued.");
	        return;
	    }

	    book.setAvailable(false);
	    user.borrowBook(book);
	    System.out.println(" Book '" + book.getTitle() + "' issued to '" + user.getName() + "'.");
	}


	public void returnBook(int userId, int bookId) {
	    User user = findUserById(userId);
	    Book book = findBookById(bookId);

	    if (user == null) {
	        System.out.println(" User not found.");
	        return;
	    }
	    if (book == null) {
	        System.out.println(" Book not found.");
	        return;
	    }

	    if (!user.getBorrowedBooks().contains(book)) {
	        System.out.println(" This user did not borrow this book.");
	        return;
	    }

	    book.setAvailable(true);
	    user.returnBook(book);
	    System.out.println(" Book '" + book.getTitle() + "' returned by '" + user.getName() + "'.");
	}


	public void listBooks() {
	    System.out.println("------------------------------------------------------------------");
	    System.out.printf("%-5s %-25s %-20s %-10s\n", "ID", "Title", "Author", "Status");
	    System.out.println("------------------------------------------------------------------");

	    for (Book book : books) {
	        String status = book.isAvailable() ? "Available " : "Issued ";
	        System.out.printf("%-5d %-25s %-20s %-10s\n",
	                book.getBookId(), book.getTitle(), book.getAuthor(), status);
	    }

	    System.out.println("------------------------------------------------------------------");
	}


	public void listUsers() {
	    System.out.println("--------------------------------------------------");
	    System.out.printf("%-5s %-20s %-20s\n", "ID", "Name", "Borrowed Books");
	    System.out.println("--------------------------------------------------");

	    for (User user : users) {
	        StringBuilder borrowed = new StringBuilder();
	        if (user.getBorrowedBooks().isEmpty()) {
	            borrowed.append("None");
	        } else {
	            for (Book book : user.getBorrowedBooks()) {
	                borrowed.append(book.getTitle()).append(", ");
	            }
	            borrowed.setLength(borrowed.length() - 2); // Remove trailing comma
	        }

	        System.out.printf("%-5d %-20s %-20s\n", user.getUserId(), user.getName(), borrowed.toString());
	    }

	    System.out.println("--------------------------------------------------");
	}

}
