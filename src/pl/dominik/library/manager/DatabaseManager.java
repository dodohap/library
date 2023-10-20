package pl.dominik.library.manager;

import pl.dominik.library.object.Book;
import pl.dominik.library.object.SeriesBook;
import pl.dominik.library.object.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseManager {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void init() {
        //connect to database
        //get books and users from database
        this.books.add(new SeriesBook(UUID.randomUUID(),
                        "Kasacja", "Remigiusz Mróz", "Joanna Chyłka", "Joanna Chyłka", 1));
        this.books.add(new SeriesBook(UUID.randomUUID(),
                        "Zaginięcie", "Remigiusz Mróz", "Joanna Chyłka", "Joanna Chyłka", 2));

        this.books.add(new Book(UUID.randomUUID(), "Nie mów nikomu", "Harlan Coben"));
    }

    public void clear() {
        //kill database connection
        this.books.clear();
        this.users.clear();
    }

    public void addNewUser(User user) {
        if (this.users.contains(user))
            return;

        this.users.add(user);
        //add new user to database
    }
    public void updateUser(User user) {
        if (!this.users.contains(user))
            return;

        this.users.add(user);
        //update user in database
    }

    public void removeUser(User user) {
        if (!this.users.contains(user))
            return;

        this.users.remove(user);
        //remove user from database
    }

    public void addNewBook(Book book) {
        if (this.books.contains(book))
            return;

        this.books.add(book);
        //add new book to database
    }

    public void updateBook(Book book) {
        if (!this.books.contains(book))
            return;

        this.books.add(book);
        //update book in database
    }
    public void removeBook(Book book) {
        if (!this.books.contains(book))
            return;

        this.books.remove(book);
        //remove book from database
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByUUID(UUID uuid) {
        return this.users
                .stream()
                .filter(user -> user.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    public Book getBookByUUID(UUID uuid) {
        return this.books
                .stream()
                .filter(book -> book.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }
}
