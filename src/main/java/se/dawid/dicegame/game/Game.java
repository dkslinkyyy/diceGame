package se.dawid.dicegame.game;

import se.dawid.dicegame.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {

    //hårdkoddat bs
    private final int MAX_TURNS = 2;
    private int turnsLeft = MAX_TURNS;

    private final int rounds;

    private final List<Player> players;

    private int playerCount;

    protected Game(String internalName, int playerCount, int rounds) {
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
        this.rounds = rounds;

        System.out.println("Förbereder %s..".replaceAll("%s", internalName));
        Utils.sleep();
    }

    public abstract void switchTurn(Scanner scanner);

    public abstract void handleTurn(Scanner scanner);

    public abstract void declareWinner(Scanner scanner);

    public abstract void setupPlayers(Scanner scanner);

    public boolean canSwitchTurn() {
        return turnsLeft <= 0;
    }

    public boolean canStart() {
        return !players.isEmpty();
    }

    public int getRounds() {
        return rounds;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public int getPlayersCount() {
        return playerCount;
    }

    public boolean hasPlayers() {
        return !players.isEmpty();
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }
}

