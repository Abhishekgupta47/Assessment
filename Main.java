import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Book Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability Status (Available/Checked Out): ");
                    String availabilityStatus = scanner.nextLine();
                    library.addBook(bookId, title, author, genre, availabilityStatus);
                    break;

                case 2:
                    library.viewAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID or Title to search: ");
                    String searchTerm = scanner.nextLine();
                    library.searchBook(searchTerm);
                    break;

                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateBookId = scanner.nextLine();
                    System.out.print("Enter New Title (or leave empty to keep current): ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Author (or leave empty to keep current): ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter New Availability Status (Available/Checked Out, or leave empty to keep current): ");
                    String newStatus = scanner.nextLine();
                    library.updateBook(updateBookId, newTitle, newAuthor, newStatus);
                    break;

                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteBookId = scanner.nextLine();
                    library.deleteBook(deleteBookId);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
