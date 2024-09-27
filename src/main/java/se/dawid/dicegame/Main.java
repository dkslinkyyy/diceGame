package se.dawid.dicegame;


import se.dawid.dicegame.game.Game;
import se.dawid.dicegame.game.GameFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = null;

        while(true) {
            if(game != null) {
                if(game.canSwitchTurn()) {
                    game.switchTurn(sc);
                }
                game.handleTurn(sc); //start

            }else {
                System.out.println("""
                    Välj spelläge: 
                    [1]: Mot riktig spelare
                    [2]: Mot dator
                    [3]: Dator mot dator (simulering)
                    """);

                int option = sc.nextInt();
                game = GameFactory.createGame(option, sc);
            }


        }

    }

}


