package se.dawid.dicegame;

import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import javax.swing.*;
import java.util.*;

public class Main {
    private static Scanner scanner;

    private static boolean inGame = false;

    private static final int MAX_TURNS = 2;
    private static int turns = MAX_TURNS;

    private static int computerPoints = 0;

    private static String input;

    private static int rolledDice = 0;

    private static int rounds = 0;

    private static Player player;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            if (inGame) {
                handleGameLoop();
            } else {

                setup();
                inGame = true;
            }
        }
    }

    public static void handleGameLoop() {
        if(rounds == 0) {
            gameEnd();
            return;
        }
        if (player.getTurns() == 0) {
            if (turns == 0) {
                player.setTurns(MAX_TURNS);
                turns = MAX_TURNS;

                rounds--;

                return;
            }

            processTurnForPC();

            turns--;

            return;
        }

        Utils.print(Message.ROLL_DICE, false, String.valueOf(player.getTurns()));



        input = scanner.nextLine();

        if (input.equalsIgnoreCase("")) {

            processTurn();
        }

    }

    public static void gameEnd() {
        System.out.println("End");

        System.exit(0);
    }

    public static void processTurnForPC() {
        Utils.print(Message.ROLLING, true);
        Utils.sleep();

        rolledDice = Utils.rollDice();
        computerPoints += rolledDice;
        Utils.print(Message.PC_ROLLED_DICE, true, String.valueOf(computerPoints));

        Utils.sleep();
    }

    public static void processTurn() {
        Utils.print(Message.ROLLING, true);
        Utils.sleep();

        rolledDice = Utils.rollDice();

        Utils.print(Message.ROLLED_DICE, true, String.valueOf(rolledDice));
        player.addPoints(rolledDice);
        player.setTurns(player.getTurns() - 1);


    }

    public static void setup() {
        Utils.print(Message.AMOUNT_OF_ROUND, false);

        if (scanner.hasNextInt()) {
            rounds = scanner.nextInt();
            System.out.println(rounds);


            player = new Player("spelare1", 0, MAX_TURNS);
            Utils.print(Message.GAME_START, true);
            return;
        }

        scanner.next();
        setup();

    }

}


