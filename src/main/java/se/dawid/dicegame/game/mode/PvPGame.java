package se.dawid.dicegame.game.mode;


import se.dawid.dicegame.game.Game;
import se.dawid.dicegame.game.Player;
import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import java.util.Scanner;

public class PvPGame extends Game {

    public PvPGame(int playersInGame, int rounds) {
        super("Spelare mot spelare", playersInGame, rounds);

    }


    @Override
    public void switchTurn(Scanner scanner) {

    }

    @Override
    public void handleTurn(Scanner scanner) {

    }

    @Override
    public void declareWinner(Scanner scanner) {

    }

    public void setupPlayers(Scanner sc) {
        for (int i = 0; i < getPlayersCount(); i++) {
            Utils.print(Message.PLAYER_JOINING, false, String.valueOf(i+1));
            String playerName = sc.nextLine();
            addPlayer(new Player(playerName, 0));
            Utils.print(Message.PLAYER_JOINED, false, playerName);
            Utils.sleep();
        }
    }
}
