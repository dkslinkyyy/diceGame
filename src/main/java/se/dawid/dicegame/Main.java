package se.dawid.dicegame;

import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static int MAX_TURNS = 2;

    public static void main(String[] args) {
        Game game = new Game();
        game.setupPlayers();
        game.start();
    }

    static class Game {

    private Player[] players = new Player[2];
    private int currentPlayerIndex = 0;
    private int turnsRemaining = Main.MAX_TURNS;

    public void setupPlayers() {
        for (int i = 0; i < players.length; i++) {
            Utils.print(Message.PLAYER_JOINING, false);
            String playerName = Main.scanner.nextLine();
            players[i] = new Player(playerName, 0);
            printWithDelay(Message.PLAYER_JOINED, playerName);
        }
    }

    public void start() {
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            handleTurn(currentPlayer);
        }
    }

    private void handleTurn(Player player) {
        printWithDelay(Message.NEXT_TURN, player.getName());
        Utils.print(Message.ROLL_DICE, false, String.valueOf(turnsRemaining));

        String input = Main.scanner.nextLine();
        if (input.equalsIgnoreCase("roll")) {
            int roll = Utils.rollDice();
            printWithDelay(Message.ROLLED_DICE, String.valueOf(roll));

            player.addPoints(roll);
            turnsRemaining--;

            if (turnsRemaining == 0) {
                player.setPlayedTurn(true);
                printWithDelay(Message.TOTAL_POINTS, String.valueOf(player.getPoints()));
                if (checkGameOver()) {
                    declareWinner();
                } else {
                    switchPlayer();
                }
            }
        }
    }

    private void switchPlayer() {
        turnsRemaining = Main.MAX_TURNS;
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        printWithDelay(Message.NEXT_PLAYER);
    }

    private boolean checkGameOver() {
        return players[0].hasPlayedTurn() && players[1].hasPlayedTurn();
    }

    private void declareWinner() {
        Player winner = (players[0].getPoints() > players[1].getPoints()) ? players[0] : players[1];
        Utils.print(Message.WINNER_PRE, true);
        Utils.sleep();
        Utils.print(Message.WINNER, true, winner.getName(), String.valueOf(winner.getPoints()));
        System.exit(0);
    }

    private void printWithDelay(Message message, String... args) {
        Utils.print(message, false, args);
        Utils.sleep();
    }

    }

}


