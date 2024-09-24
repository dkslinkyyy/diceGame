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

    public static void print(Message msg, boolean spacing, String... values) {
        String formatted = msg.text;

        for(String value : values) {

            if (formatted.contains("%p")) {
                formatted = formatted.replaceAll("%p", value);

            } else if (formatted.contains("%s")) {
                formatted = formatted.replaceAll("%s", value);
            }


        }
        if(spacing) {
            System.out.println();
        }
        System.out.println(formatted);

    }



}
