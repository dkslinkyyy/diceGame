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
    private static String input;

    private static Player[] players = new Player[2];

    private static Player nextPlayer = null;

    public static void main(String[] args) {
        while (true) {
            if (inGame) {
                handleGameLoop();
            } else {
                setupPlayers();
                inGame = true;

                nextPlayer = players[0];
                Utils.print(Message.NEXT_TURN, false, nextPlayer.getName());
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
        Utils.print(Message.ROLLED_DICE, false, String.valueOf(rolledResult));
        nextPlayer.setPoints(nextPlayer.getPoints() + rolledResult);
        turns--;

        if (turns == 0) {
            nextPlayer.setPlayedTurn(true);
            checkWinner();
            Utils.print(Message.TOTAL_POINTS, false, String.valueOf(nextPlayer.getPoints()));
            switchPlayer();
        }

        Utils.sleep();
    }

    public static void checkWinner() {
        if (players[0].hasPlayedTurn() && players[1].hasPlayedTurn()) {
            Player winner = players[0].getPoints() > players[1].getPoints() ? players[0] : players[1];
            Utils.print(Message.WINNER_PRE, true);
            Utils.sleep();
            Utils.print(Message.WINNER, true, winner.getName(), String.valueOf(winner.getPoints()));
            System.exit(0);
        }
    }

    public static void setupPlayers() {
        for (int i = 0; i < players.length; i++) {
            Utils.print(Message.PLAYER_JOINING, false);

            String player_name = scanner.nextLine();

            players[i] = new Player(player_name, 0);

            Utils.print(Message.PLAYER_JOINED, false, player_name);
            Utils.sleep();
        }
    }
    private static void switchPlayer() {
        nextPlayer = (nextPlayer == players[0]) ? players[1] : players[0];
        turns = MAX_TURNS;


        Utils.print(Message.NEXT_PLAYER,false);
        Utils.print(Message.NEXT_TURN, false, nextPlayer.getName());
        Utils.sleep();
    }

}


