package pl.dominik.library.object;

import java.util.UUID;

public class Book {
    private final UUID uuid;
    private final String title;
    private final String author;
    private UUID holderUUID;

    public Book(UUID uuid, String title, String author) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public UUID getHolderUUID() {
        return holderUUID;
    }

    public void setHolderUUID(UUID holderUUID) {
        this.holderUUID = holderUUID;
    }

    public boolean isAvailable() {
        return this.holderUUID == null;
    }
}
