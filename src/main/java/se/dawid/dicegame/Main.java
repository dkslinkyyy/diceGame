package se.dawid.dicegame;

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
                Message.NEXT_TURN.print(nextPlayer.getName());
                sleep();

            }

        }

    }
    public static void handleGameLoop() {
        Message.ROLL_DICE.print(String.valueOf(MAX_TURNS));

        input = scanner.nextLine();

        if (input.equalsIgnoreCase("roll")) {
            processTurn();
        }
    }

    public static void processTurn() {
        int rolledResult = rollDice();
        Message.ROLLED_DICE.print(String.valueOf(rolledResult));
        nextPlayer.setPoints(nextPlayer.getPoints() + rolledResult);
        turns--;

        if (turns == 0) {
            nextPlayer.setPlayedTurn(true);
            checkWinner();
            Message.TOTAL_POINTS.print(String.valueOf(nextPlayer.getPoints()));
            switchPlayer();
        }

        sleep();
    }

    public static void checkWinner() {
        if (players[0].hasPlayedTurn() && players[1].hasPlayedTurn()) {
            Player winner = players[0].getPoints() > players[1].getPoints() ? players[0] : players[1];
            Message.WINNER_PRE.print();
            sleep();
            Message.WINNER.print(winner.getName(), String.valueOf(winner.getPoints()));
            System.exit(0);
        }
    }

    public static void setupPlayers() {
        for (int i = 0; i < players.length; i++) {
            Message.PLAYER_JOINING.print();

            String player_name = scanner.nextLine();

            players[i] = new Player(player_name, 0);

            Message.PLAYER_JOINED.print(player_name);
            sleep();
        }
    }
    private static void switchPlayer() {
        nextPlayer = (nextPlayer == players[0]) ? players[1] : players[0];
        turns = MAX_TURNS;
        Message.NEXT_PLAYER.print();
        Message.NEXT_TURN.print(nextPlayer.getName());
        sleep();
    }


    public static int rollDice() {
        Random rand = new Random();

        return rand.nextInt(6) + 1;

    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}


