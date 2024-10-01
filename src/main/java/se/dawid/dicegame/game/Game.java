package se.dawid.dicegame.game;

import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {

    private final int MAX_TURNS = 2;
    private final int playerCount;
    private final int rounds;
    private final List<Player> players;

    private int turnsLeft = MAX_TURNS;
    private int currentPlayerIndex;
    private int roundsLeft;

    public Game(int playerCount, int rounds) {
        this.playerCount = playerCount;
        this.rounds = rounds;
        this.roundsLeft = rounds;
        this.players = new ArrayList<>();
    }

    public void run(Scanner scanner) {
        while (roundsLeft > 0) {
            playRound(scanner);

            if (isRoundComplete()) {
                handleEndOfRound();

            }

            if(roundsLeft == 0)  {
                declareWinner();
                break;
            }
        }
    }

    private void playRound(Scanner scanner) {
        while (turnsLeft > 0) {
            playTurn(scanner);
        }
        completeTurn();

    }

    private void playTurn(Scanner scanner) {
        handleTurn(scanner);
        turnsLeft--;
    }

    private void completeTurn() {
        getCurrentPlayer().setPlayedTurn(true);
        Utils.print(Message.TOTAL_POINTS, true, String.valueOf(getCurrentPlayer().getPoints()));

        if (roundsLeft > 0) {
            turnsLeft = MAX_TURNS;
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            if (!isRoundComplete()) {
                Utils.print(Message.NEXT_PLAYER, true);
                Utils.sleep();
                Utils.print(Message.NEXT_TURN, false, getCurrentPlayer().getName());
                Utils.sleep();

            }
        }
    }


    private void handleEndOfRound() {
        roundsLeft--;
        resetPlayersForNextRound();
    }

    public void declareWinner() {
        Player winner = players.stream().max((p1, p2) -> Integer.compare(p1.getPoints(), p2.getPoints())).orElse(null);
        if (winner != null) {
            Utils.print(Message.WINNER_PRE, false);
            Utils.sleep();
            Utils.print(Message.WINNER, false, String.valueOf(winner.getName()), String.valueOf(winner.getPoints()));
            System.exit(0); // avsluta spelet
        }
    }

    public abstract void handleTurn(Scanner scanner);

    public abstract void setup(Scanner scanner);

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex); //returnerar nästa/nuvarande spelaren med hjälp av nuvarande index(
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private boolean isRoundComplete() {
        return players.stream().allMatch(Player::hasPlayedTurn);
    }

    private void resetPlayersForNextRound() {
        players.forEach(player -> player.setPlayedTurn(false));
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }
}


