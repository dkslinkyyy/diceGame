package se.dawid.dicegame;

import java.io.IOException;
import java.util.*;


public class Main {

    private static final String ROLL_DICE_MSG = "Skriv 'roll' för att kasta tärningen ";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean inGame = false;

        int turns = 0;

        String input;

        Player nextPlayer = null, player1 = null, player2 = null;


        Player[] players = new Player[2];

        while (true) {
            if (inGame) {

                System.out.println("Näst på tur " + nextPlayer.getName());
                System.out.println(ROLL_DICE_MSG);
                input = scanner.nextLine();


                if (input.equalsIgnoreCase("roll")) {

                    int rolledResult = rollDice();
                    System.out.println("Du kastade " + rolledResult);

                    nextPlayer.setPoints(nextPlayer.getPoints() + rolledResult);
                    System.out.println("Det totala utfallet: " + nextPlayer.getPoints());
                    System.out.println('\n');

                    turns++;


                    if(turns == 2) {

                        nextPlayer.setPlayedTurn(true);

                        if(player1.hasPlayedTurn() && player2.hasPlayedTurn()) {
                            int winner = Math.max(player1.getPoints(), player2.getPoints());
                            Player winningPlayer = winner == player1.getPoints() ? player1 : player2;
                            System.out.println("Grattis " + winningPlayer.getName() + " du vann med " + winningPlayer.getPoints());
                            break;
                        }

                        if(nextPlayer == player1) {
                            nextPlayer = player2;
                        }else{
                            nextPlayer = player1;
                        }

                        turns = 0;
                        System.out.println("Byter till nästa spelare!");

                    }

                }


            } else {

                for(int i = 0; i<players.length; i++) {
                    System.out.println("Ange spelare "+ (i+1) +" namn");
                    String player_name = scanner.nextLine();
                    players[i] = new Player(player_name, 0);

                    System.out.println(players.length + " " + i);
                    System.out.println(player_name + " är nu med i spelet");
                }


                nextPlayer = players[0];

                inGame = true;
            }


        }

    }

    public static int rollDice() {
        Random rand = new Random();

        return rand.nextInt(6) + 1;
    }


    enum Message {


    }
}


