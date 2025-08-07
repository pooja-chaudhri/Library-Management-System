import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Library library = new Library();
		Scanner sc = new Scanner(System.in);

		// Sample books
		library.addBook(new Book(1, "Java Basics", "John Smith", true));
		library.addBook(new Book(2, "OOP Concepts", "James Gosling", true));
		library.addBook(new Book(3, "Data Structures", "Robert Lafore", true));
		library.addBook(new Book(4, "Algorithms", "Thomas Cormen", true));
		library.addBook(new Book(5, "Clean Code", "Robert Martin", true));

		// Sample users
		library.registerUser(new User(1, "John"));
		library.registerUser(new User(2, "Jay"));
		library.registerUser(new User(3, "Riya"));

		int choice;
		System.out.println(" Welcome to the Library Management System  ");

		do {
			System.out.println("\n  Please choose an option:");
			System.out.println("1.  View Available Books");
			System.out.println("2.  View Registered Users");
			System.out.println("3.  Issue a Book to User");
			System.out.println("4.  Return a Book");
			System.out.println("0.  Exit");
			System.out.print("  Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				System.out.println("\n List of Books in the Library:");
				library.listBooks();
				
				System.out.print("\n Press Enter to continue...");
			    sc.nextLine(); 
			    sc.nextLine(); // Wait for Enter
			}
			case 2 -> {
				System.out.println("\n Registered Users:");
				library.listUsers();
				
				System.out.print("\n Press Enter to continue...");
			    sc.nextLine(); 
			    sc.nextLine(); // Wait for Enter
			}
			case 3 -> {
				System.out.print(" Enter User ID: ");
				int userId = sc.nextInt();
				System.out.print(" Enter Book ID to issue: ");
				int bookId = sc.nextInt();
				library.issueBook(userId, bookId);
				
				System.out.print("\n Press Enter to continue...");
			    sc.nextLine(); 
			    sc.nextLine(); // Wait for Enter
			}
			case 4 -> {
				System.out.print(" Enter User ID: ");
				int userId = sc.nextInt();
				System.out.print(" Enter Book ID to return: ");
				int bookId = sc.nextInt();
				library.returnBook(userId, bookId);
				
				System.out.print("\n Press Enter to continue...");
			    sc.nextLine(); 
			    sc.nextLine(); // Wait for Enter
			}
			case 0 -> {
				System.out.println(" Thank you for using the Library System. Goodbye!");
			}
			default -> {
				System.out.println(" Invalid choice. Please try again with a number between 0 and 4.");
			}
			}
		} while (choice != 0);

		sc.close();
	}
}
