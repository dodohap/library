package pl.dominik.library;

import pl.dominik.library.manager.DatabaseManager;

public class Library {
    private final DatabaseManager databaseManager = new DatabaseManager();

    public void onEnable() {
        this.databaseManager.init();
    }
    public void onDisable() {
        this.databaseManager.clear();
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
