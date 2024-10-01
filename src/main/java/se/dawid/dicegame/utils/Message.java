package se.dawid.dicegame.utils;

public enum Message {

    THROWING_DICE("Kastar..."),
    ROLL_DICE("Tryck på 'enter' knappen för att kasta tärningen, Du har %s försök"),

    PLAYER_ROLLED_DICE("Du kastade %s"),

    PC_ROLLED_DICE("%p kastade tärningen och fick %s"),

    NEXT_TURN("Näst på tur %p"),

    NEXT_PLAYER("Byter till nästa spelare!"),

    PLAYER_JOINED("%p är nu med i spelet."),

    PLAYER_JOINING("Ange namn på spelare %s"),

    TOTAL_POINTS("Det totala utfallet blev %s"),

    WINNER_PRE("Vinnaren är..."),

    WINNER("Grattis %p, Du har vunnit! Spelaren hade %s poäng!"),

    WINNER_DRAW("Atans! Ingen vann! Det blev oavgjort.. Båda spelarna hade %s poäng");

    public final String text;

    Message(String text) {
        this.text = text;
    }





}
