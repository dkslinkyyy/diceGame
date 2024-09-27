package se.dawid.dicegame.game;

import se.dawid.dicegame.game.mode.PvPGame;

import java.util.Scanner;

public class GameFactory {

    public static Game createGame(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.println("Hur många vill du spela mot?");
                int players = scanner.nextInt();
                System.out.println("Hur många rundor vill du spela? ");
                int rounds = scanner.nextInt();
                return new PvPGame(players, rounds);
            default:
                return null;
        }

    }
}
