package pl.dominik.library.object;

import java.util.UUID;

public class SeriesBook extends Book {
    private final String seriesName;
    private final String mainCharacterName;
    private final int part;

    public SeriesBook(UUID uuid, String title, String author, String seriesName, String mainCharacterName, int part) {
        super(uuid, title, author);

        this.seriesName = seriesName;
        this.mainCharacterName = mainCharacterName;
        this.part = part;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getMainCharacterName() {
        return mainCharacterName;
    }

    public int getPart() {
        return part;
    }
}
