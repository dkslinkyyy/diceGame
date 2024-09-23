package se.dawid.dicegame;

import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import javax.swing.*;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static boolean inGame = false;

    private static int MAX_TURNS = 2;
    private static int turns = MAX_TURNS;
    private static int winnerPoints = 0;
    private static String input;

    private static Player[] players = new Player[3];

    private static Player nextPlayer, winner;
    private static int nextPlayerIndex = 0;

    public static void main(String[] args) {
        while (true) {
            if (inGame) {
                handleGameLoop();
            } else {
                setupPlayers();

                inGame = true;

                nextPlayer = players[0];

                Utils.print(Message.NEXT_TURN, true,  nextPlayer.getName());
                Utils.sleep();

            }

        }

    }
    public static void handleGameLoop() {
        Utils.print(Message.ROLL_DICE, false, String.valueOf(turns));
        input = scanner.nextLine();

        if (input.equalsIgnoreCase("roll")) {
            processTurn();
        }
    }

    public static void processTurn() {
        int rolledResult = Utils.rollDice();
        Utils.print(Message.ROLLED_DICE, true, String.valueOf(rolledResult));
        nextPlayer.addPoints(rolledResult);

        if(nextPlayer.getPoints() > winnerPoints) {
            winnerPoints = nextPlayer.getPoints();
            winner = nextPlayer;
        }

        turns--;

        if (turns == 0) {
            nextPlayer.setPlayedTurn(true);
            checkWinner();
            switchPlayer();
        }

        Utils.sleep();
    }

    public static void checkWinner() {
        int gameFinished = Arrays.stream(players).filter(player -> !player.hasPlayedTurn()).toList().size();

        if (gameFinished == 0 && winner != null) {
            Utils.print(Message.WINNER_PRE, false);
            Utils.sleep();
            Utils.print(Message.WINNER, false, winner.getName(), String.valueOf(winner.getPoints()));
            Utils.sleep();

            Arrays.stream(players).filter(player -> player !=winner).forEach(player -> {
                Utils.print(Message.TOTAL_POINTS, false, player.getName(), String.valueOf(player.getPoints()));
            });

            System.exit(0);
        }
    }

    public static void setupPlayers() {
        for (int i = 0; i < players.length; i++) {
            String nextPlayerSelection = String.valueOf(i+1);
            Utils.print(Message.PLAYER_JOINING, false, nextPlayerSelection);
            String player_name = scanner.nextLine();

            players[i] = new Player(player_name, 0);
            Utils.print(Message.PLAYER_JOINED, false, player_name);

            Utils.sleep();
        }
    }
    private static void switchPlayer() {
        nextPlayerIndex++;
        nextPlayer = players[nextPlayerIndex];
        System.out.println(nextPlayerIndex);
        turns = MAX_TURNS;
        Utils.print(Message.NEXT_PLAYER, false);

        Utils.print(Message.NEXT_TURN, false, nextPlayer.getName());
        Utils.sleep();
    }

}


