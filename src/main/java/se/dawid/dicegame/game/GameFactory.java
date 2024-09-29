package se.dawid.dicegame.game;

import se.dawid.dicegame.game.mode.AIGame;
import se.dawid.dicegame.game.mode.PvPGame;
import se.dawid.dicegame.game.mode.SimulationGame;

import java.util.Scanner;

public class GameFactory {

    public static Game createGame(int option, Scanner scanner) {
        int players = 0;
        int rounds = 0;

        switch (option) {
            case 1:
                System.out.println("Hur många vill du spela mot?");
                players = Integer.parseInt(scanner.nextLine());
                System.out.println("Hur många rundor vill du spela? ");
                rounds = Integer.parseInt(scanner.nextLine());
                return new PvPGame(players, rounds);
            case 2:
                System.out.println("Hur många rundor vill du spela?");
                rounds = Integer.parseInt(scanner.nextLine());
                return new SimulationGame(rounds);
            case 3:
                System.out.println("Hur många rundor vill du spela?");
                rounds = Integer.parseInt(scanner.nextLine());
                return new AIGame(rounds);
            default:
                return null;
        }

    }
}
