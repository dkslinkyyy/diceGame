package se.dawid.dicegame.game.mode;


import se.dawid.dicegame.game.Game;
import se.dawid.dicegame.game.Player;
import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import java.util.Scanner;

public class PvPGame extends Game {

    public PvPGame(int playersInGame, int rounds) {
        super(playersInGame, rounds);

    }

    @Override
    public void handleTurn(Scanner scanner) {
        Player currentPlayer = getCurrentPlayer();

        Utils.print(Message.ROLL_DICE, false, String.valueOf(getTurnsLeft()));

        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("")) {
            int rolledResult = Utils.rollDice();
            Utils.print(Message.PLAYER_ROLLED_DICE, true, String.valueOf(rolledResult));

            currentPlayer.addPoints(rolledResult);
        }
    }


    @Override
    public void setup(Scanner sc) {
        for (int i = 0; i <= super.getPlayerCount(); i++) {
            Utils.print(Message.PLAYER_JOINING, false, String.valueOf(i+1));
            String playerName = sc.nextLine();
            addPlayer(new Player(playerName, 0));
            Utils.print(Message.PLAYER_JOINED, true, playerName);
        }
    }


}
