let books = []; // Store books in memory

// Function to add a new book to the list
document.getElementById("addBookForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let bookId = document.getElementById("bookId").value;
    let title = document.getElementById("title").value;
    let author = document.getElementById("author").value;
    let genre = document.getElementById("genre").value;
    let availabilityStatus = document.getElementById("status").value;

    let newBook = {
        bookId: bookId,
        title: title,
        author: author,
        genre: genre,
        availabilityStatus: availabilityStatus
    };

    books.push(newBook);
    document.getElementById("addBookForm").reset();
    displayBooks();
});

// Display all books
function displayBooks() {
    let bookListContainer = document.getElementById("bookList");
    bookListContainer.innerHTML = "";

    if (books.length === 0) {
        bookListContainer.innerHTML = "<p>No books available in the library.</p>";
    } else {
        books.forEach((book) => {
            let bookItem = document.createElement("div");
            bookItem.classList.add("book-item");
            bookItem.innerHTML = `
                <strong>${book.title}</strong> by ${book.author} (Genre: ${book.genre}, Status: ${book.availabilityStatus})
                <button onclick="deleteBook('${book.bookId}')">Delete</button>
                <button onclick="showUpdateForm('${book.bookId}')">Update</button>
            `;
            bookListContainer.appendChild(bookItem);
        });
    }
}

// Delete a book
function deleteBook(bookId) {
    books = books.filter(book => book.bookId !== bookId);
    displayBooks();
}

// Function to show the update form with current book data
function showUpdateForm(bookId) {
    let book = books.find(b => b.bookId === bookId);
    if (book) {
        document.getElementById("updateBookId").value = book.bookId;
        document.getElementById("updateTitle").value = book.title;
        document.getElementById("updateAuthor").value = book.author;
        document.getElementById("updateGenre").value = book.genre;
        document.getElementById("updateStatus").value = book.availabilityStatus;

        document.getElementById("updateFormSection").style.display = "block";
    }
}

// Function to handle book update
document.getElementById("updateBookForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let bookId = document.getElementById("updateBookId").value;
    let title = document.getElementById("updateTitle").value;
    let author = document.getElementById("updateAuthor").value;
    let genre = document.getElementById("updateGenre").value;
    let availabilityStatus = document.getElementById("updateStatus").value;

    let bookIndex = books.findIndex(book => book.bookId === bookId);
    if (bookIndex !== -1) {
        books[bookIndex] = {
            bookId: bookId,
            title: title,
            author: author,
            genre: genre,
            availabilityStatus: availabilityStatus
        };
        document.getElementById("updateBookForm").reset();
        document.getElementById("updateFormSection").style.display = "none";
        displayBooks();
    }
});

// Function to close the update form
function closeUpdateForm() {
    document.getElementById("updateFormSection").style.display = "none";
}

// Function to search for a book
function searchBook() {
    let searchTerm = document.getElementById("searchInput").value.toLowerCase();
    let searchResultsContainer = document.getElementById("searchResults");
    searchResultsContainer.innerHTML = "";

    if (searchTerm === "") {
        searchResultsContainer.innerHTML = "";
        return;
    }

    let searchResults = books.filter((book) => 
        book.bookId.toLowerCase().includes(searchTerm) || 
        book.title.toLowerCase().includes(searchTerm)
    );

    if (searchResults.length === 0) {
        searchResultsContainer.innerHTML = "<p>No books found matching the search term.</p>";
    } else {
        searchResults.forEach((book) => {
            let bookItem = document.createElement("div");
            bookItem.classList.add("book-item");
            bookItem.innerHTML = `
                <strong>${book.title}</strong> by ${book.author} (Genre: ${book.genre}, Status: ${book.availabilityStatus})
            `;
            searchResultsContainer.appendChild(bookItem);
        });
    }
}

// Function to close the program
function closeProgram() {
    // Attempt to close the window (this will only work if the user opened the window using window.open())
    if (window.close) {
        window.close();
    } else {
        alert("Sorry, this browser does not support closing windows via script.");
    }
}
