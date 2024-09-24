package se.dawid.dicegame;

public class Player {

    private final String name;
    private int points, turns;
    private boolean playedTurn = false;

    public Player(String name, int points, int turns) {
        this.name = name;
        this.points = points;
        this.turns = turns;
    }

    public boolean hasPlayedTurn() {
        return playedTurn;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
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
