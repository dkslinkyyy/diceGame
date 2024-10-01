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

        Utils.print(Message.THROWING_DICE, true);

        Utils.sleep();
        int rolledDice = Utils.rollDice();
        Utils.print(Message.PC_ROLLED_DICE, true, currentPlayer.getName(), String.valueOf(rolledDice));
        currentPlayer.addPoints(rolledDice);

        Utils.sleep();

    }

    @Override
    public void setup(Scanner scanner) {
        System.out.println("Skapar fake spelare..");
        addPlayer(new Player("Dator_1", 0));
        addPlayer(new Player("Dator_2", 0));
        System.out.println("Klart!");
    }


}
