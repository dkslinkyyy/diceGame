package se.dawid.dicegame;


import se.dawid.dicegame.game.Game;
import se.dawid.dicegame.game.GameFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Game selectedGame = runGameSelection(sc);

        selectedGame.setup(sc);
        selectedGame.run(sc);

    }

    public static Game runGameSelection(Scanner sc) {
        Game game = null;

        do {
            System.out.println("""
                    Välj spelläge: 
                    [1]: Mot riktig spelare
                    [2]: Mot dator
                    [3]: Dator mot dator (simulering)
                    """);

            int option = Integer.parseInt(sc.nextLine());
            game = GameFactory.createGame(option, sc);

        }while(game == null);

        return game;
    }

}


