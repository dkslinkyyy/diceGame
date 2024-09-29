package se.dawid.dicegame.game;

import se.dawid.dicegame.utils.Message;
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
    private int currentPlayerIndex;

    public Game(int playerCount, int rounds) {
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
        this.rounds = rounds;
    }

    public void run(Scanner scanner) {
        Utils.print(Message.NEXT_TURN, true, getCurrentPlayer().getName());

        while(true) {
            if(canSwitchTurn()) {
                switchTurn(scanner);
            }

            handleTurn(scanner);
        }
    }

    public void switchTurn(Scanner scanner) {
        turnsLeft = MAX_TURNS;
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        Utils.print(Message.NEXT_PLAYER, true);
        Utils.sleep();
        Utils.print(Message.NEXT_TURN, false, getCurrentPlayer().getName());

    }

    public void declareWinner(Scanner scanner) {
        Player winner = getPlayers().stream().max((p1, p2) -> Integer.compare(p1.getPoints(), p2.getPoints())).orElse(null);
        if (winner != null) {
            Utils.print(Message.WINNER_PRE, false);
            Utils.sleep();
            Utils.print(Message.WINNER, false, String.valueOf(winner.getName()), String.valueOf(winner.getPoints()));

            System.exit(0);
        }
    }

    public abstract void handleTurn(Scanner scanner);


    public abstract void setup(Scanner scanner);


    public boolean canSwitchTurn() {
        return turnsLeft == 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isGameOver() {
        return players.stream().allMatch(Player::hasPlayedTurn);
    }

    public void decreaseTurns(int decrease) {
        turnsLeft -= decrease;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }
}

