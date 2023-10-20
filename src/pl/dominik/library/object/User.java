package pl.dominik.library.object;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID uuid;
    private final String name;
    private final String lastName;
    private final List<UUID> borrowedBooksId = new ArrayList<>();

    public User(UUID uuid, String name, String lastName) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<UUID> getBorrowedBooksId() {
        return borrowedBooksId;
    }

    public void addBorrowedBookId(UUID uuid) {
        this.borrowedBooksId.add(uuid);
    }

    public void removeBorrowedBookId(UUID uuid) {
        this.borrowedBooksId.remove(uuid);
    }

    public int getBorrowedBooksAmount() {
        return this.borrowedBooksId.size();
    }
}
