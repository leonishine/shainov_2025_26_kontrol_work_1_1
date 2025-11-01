package ru.itis.dis403.kontrol_work.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BoardGame {
    private long id;
    private String title;
    private String category;
    private int minPlayers;
    private int maxPlayers;
    private int playtimeMinutes;

    public BoardGame() {}

    public BoardGame(long id, String title, String category, int minPlayers, int maxPlayers, int playtimeMinutes) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playtimeMinutes = playtimeMinutes;
    }
}
