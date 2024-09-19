package se.dawid.dicegame;

import java.util.*;

public class Main {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean inGame = false;

        int turns = 2;

        String input;

        Player[] players = new Player[2];

        Player nextPlayer = null;

        while (true) {
            if (inGame) {

                Message.ROLL_DICE.print(String.valueOf(turns));

                input = scanner.nextLine();

                if(input.equalsIgnoreCase("roll")) {


                    int rolledResult = rollDice();

                    System.out.println();
                    Message.ROLLED_DICE.print(rolledResult + "");
                    System.out.println();


                    nextPlayer.setPoints(nextPlayer.getPoints() + rolledResult);

                    turns--;

                    sleep();

                    if(turns == 0) {

                        nextPlayer.setPlayedTurn(true);

                        if(players[0].hasPlayedTurn() && players[1].hasPlayedTurn()) {
                            int winner = Math.max(players[0].getPoints(), players[1].getPoints());
                            Player winningPlayer = winner == players[0].getPoints() ? players[0] : players[1];

                            Message.WINNER_PRE
                                    .print();

                            sleep();

                            Message.WINNER
                                    .print(winningPlayer.getName(),
                                            String.valueOf(winningPlayer.getPoints()));

                            break;
                        }

                        Message.TOTAL_POINTS
                                .print(nextPlayer.getPoints()+"");

                        sleep();

                        if(nextPlayer == players[0]) {
                            nextPlayer = players[1];
                        }else{
                            nextPlayer = players[0];
                        }

                        turns = 2;


                        System.out.println();
                        Message.NEXT_PLAYER.print();
                        System.out.println();
                        Message.NEXT_TURN.print(nextPlayer.getName());

                        sleep();


                    }

                }


            } else {

                for(int i = 0; i<players.length; i++) {
                    Message.PLAYER_JOINING.print();

                    String player_name = scanner.nextLine();

                    players[i] = new Player(player_name, 0);

                    Message.PLAYER_JOINED.print(player_name);
                    sleep();
                }



                nextPlayer = players[0];

                System.out.println();
                Message.NEXT_TURN.print(nextPlayer.getName());

                sleep();


                inGame = true;
            }


        }

    }



}


