package se.dawid.dicegame.utils;

import java.util.Random;

public class Utils {

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

}
