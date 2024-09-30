package se.dawid.dicegame.game.mode;

import se.dawid.dicegame.game.Game;
import se.dawid.dicegame.game.Player;
import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import java.util.Scanner;

public class AIGame extends Game {

    public AIGame(int rounds) {
        super(2, rounds);
    }

    @Override
    public void handleTurn(Scanner scanner) {
        Player currentPlayer = getCurrentPlayer();

        if (currentPlayer.getName().equalsIgnoreCase("Dator")) {
            handleTurnAI(currentPlayer);
        } else {

            Utils.print(Message.ROLL_DICE, false, String.valueOf(getTurnsLeft()));

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("")) {
                int rolledResult = Utils.rollDice();
                Utils.print(Message.PLAYER_ROLLED_DICE, true, String.valueOf(rolledResult));

                currentPlayer.addPoints(rolledResult);
            }
        }

    }

    @Override
    public void setup(Scanner scanner) {
        Utils.print(Message.PLAYER_JOINING, false, String.valueOf(1));
        String playerName = scanner.nextLine();
        addPlayer(new Player(playerName, 0));
        addPlayer(new Player("Dator", 0));
    }

    public void handleTurnAI(Player currentPlayer) {
        System.out.println("Kastar..");
        Utils.sleep();
        int rolledDice = Utils.rollDice();
        Utils.print(Message.PC_ROLLED_DICE, false, currentPlayer.getName(), String.valueOf(rolledDice));
        currentPlayer.addPoints(rolledDice);

        Utils.sleep();

    }
}
