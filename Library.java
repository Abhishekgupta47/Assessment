import java.util.HashMap;
import java.util.Map;


public class Library {
    private Map<String, Book> books; // Store books by their ID

    public Library() {
        this.books = new HashMap<>();
    }

    // Add a new book to the library
    public void addBook(String bookId, String title, String author, String genre, String availabilityStatus) {
        if (books.containsKey(bookId)) {
            System.out.println("Error: Book ID already exists.");
        } else if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Error: Title and Author cannot be empty.");
        } else if (!availabilityStatus.equals("Available") && !availabilityStatus.equals("Checked Out")) {
            System.out.println("Error: Invalid availability status.");
        } else {
            Book newBook = new Book(bookId, title, author, genre, availabilityStatus);
            books.put(bookId, newBook);
            System.out.println("Book added successfully.");
        }
    }

    // View all books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books.values()) {
                book.displayBookDetails();
                System.out.println("----------------------------");
            }
        }
    }

    // Search for a book by ID or Title
    public void searchBook(String searchTerm) {
        Book foundBook = books.get(searchTerm); // Search by ID first
        if (foundBook != null) {
            foundBook.displayBookDetails();
        } else {
            // Search by title if ID is not found
            boolean found = false;
            for (Book book : books.values()) {
                if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                    book.displayBookDetails();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Book not found by the given search term.");
            }
        }
    }

    // Update book details
    public void updateBook(String bookId, String newTitle, String newAuthor, String newAvailabilityStatus) {
        Book book = books.get(bookId);
        if (book != null) {
            if (newTitle != null && !newTitle.isEmpty()) {
                book.setTitle(newTitle);
            }
            if (newAuthor != null && !newAuthor.isEmpty()) {
                book.setAuthor(newAuthor);
            }
            if (newAvailabilityStatus != null && !newAvailabilityStatus.isEmpty()) {
                if (newAvailabilityStatus.equals("Available") || newAvailabilityStatus.equals("Checked Out")) {
                    book.setAvailabilityStatus(newAvailabilityStatus);
                } else {
                    System.out.println("Invalid status. Available status should be 'Available' or 'Checked Out'.");
                }
            }
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Delete a book by ID
    public void deleteBook(String bookId) {
        if (books.containsKey(bookId)) {
            books.remove(bookId);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}

