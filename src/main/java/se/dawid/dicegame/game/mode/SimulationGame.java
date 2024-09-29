package se.dawid.dicegame.game.mode;

import se.dawid.dicegame.game.Game;
import se.dawid.dicegame.game.Player;
import se.dawid.dicegame.utils.Message;
import se.dawid.dicegame.utils.Utils;

import java.util.Scanner;

public class SimulationGame extends Game {

    public SimulationGame(int rounds) {
        super(2, rounds);
    }

    @Override
    public void handleTurn(Scanner scanner) {
        Player currentPlayer = getCurrentPlayer();

        System.out.println("Kastar..");
        Utils.sleep();
        int rolledDice = Utils.rollDice();
        Utils.print(Message.PC_ROLLED_DICE, false, currentPlayer.getName(), String.valueOf(rolledDice));
        currentPlayer.addPoints(rolledDice);

        Utils.sleep();

        decreaseTurns(1);

        if (getTurnsLeft() == 0) {
            currentPlayer.setPlayedTurn(true);
            Utils.print(Message.TOTAL_POINTS, true, String.valueOf(currentPlayer.getPoints()));

            if (isGameOver()) {
                declareWinner(scanner);
            }
        }
    }

    @Override
    public void setup(Scanner scanner) {
        System.out.println("Skapar fake spelare..");
        addPlayer(new Player("Dator_1", 0));
        addPlayer(new Player("Dator_2", 0));
        System.out.println("Klart!");
    }


}
