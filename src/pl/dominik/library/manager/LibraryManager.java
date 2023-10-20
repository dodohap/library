package pl.dominik.library.manager;

import pl.dominik.library.object.Book;
import pl.dominik.library.object.SeriesBook;
import pl.dominik.library.object.User;
import pl.dominik.library.LibraryOptions;

import java.util.UUID;

public class LibraryManager {
   private final DatabaseManager databaseManager;

    public LibraryManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void addBook(String title, String author) {
        if (title.isBlank() || author.isBlank())
            return;

        this.databaseManager.addNewBook(new Book(UUID.randomUUID(), title, author));
    }

    public void addBook(String title, String author, String seriesName, String mainCharacterName, int part) {
        if (title.isBlank() || author.isBlank() || seriesName.isBlank() || mainCharacterName.isBlank() || part <=0)
            return;

        this.databaseManager.addNewBook(new SeriesBook(UUID.randomUUID(), title, author, seriesName, mainCharacterName, part));
    }

    public void removeBook(Book book) {
        this.databaseManager.removeBook(book);
    }

    public void borrowBook(UUID userUUID, UUID bookUUID) {
        User user = this.databaseManager.getUserByUUID(userUUID);
        if (user == null) return;

        if (user.getBorrowedBooksAmount() > LibraryOptions.BORROWED_BOOKS_LIMIT)
            return;

        if (user.getBorrowedBooksId().contains(bookUUID))
            return;

        Book book = this.databaseManager.getBookByUUID(bookUUID);
        if (book == null) return;

        if (!book.isAvailable())
            return;

        user.addBorrowedBookId(bookUUID);
        book.setHolderUUID(userUUID);

        this.databaseManager.updateUser(user);
        this.databaseManager.updateBook(book);
    }

    public void giveBackBook(UUID userUUID, UUID bookUUID) {
        User user = this.databaseManager.getUserByUUID(userUUID);
        if (user == null) return;

        Book book = this.databaseManager.getBookByUUID(bookUUID);
        if (book == null) return;

        user.removeBorrowedBookId(bookUUID);
        book.setHolderUUID(null);

        this.databaseManager.updateUser(user);
        this.databaseManager.updateBook(book);
    }

    public Book findBookByTitle(String title) {
        return this.databaseManager.getBooks()
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public Book findBookByAuthor(String author) {
        return this.databaseManager.getBooks()
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .findFirst()
                .orElse(null);
    }
}
