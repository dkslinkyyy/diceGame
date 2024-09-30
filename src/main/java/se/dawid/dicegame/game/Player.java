package se.dawid.dicegame.game;

public class Player {

    private final String name;
    private int points;
    private boolean playedTurn;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
        this.playedTurn = false;
    }

    public boolean hasPlayedTurn() {
        return playedTurn;
    }

    public void setPlayedTurn(boolean playedTurn) {
        this.playedTurn = playedTurn;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
