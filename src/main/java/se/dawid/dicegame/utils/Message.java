package se.dawid.dicegame.utils;

public enum Message {

    ROLL_DICE("Skriv 'roll' för att kasta tärningen, Du har %s försök"),

    ROLLED_DICE("Du kastade %s"),

    NEXT_TURN("Näst på tur %p"),

    NEXT_PLAYER("Byter till nästa spelare!"),

    PLAYER_JOINED("%p är nu med i spelet."),

    PLAYER_JOINING("Ange namn på spelare %s"),

    TOTAL_POINTS("Det totala utfallet för %p blev %s"),

    WINNER_PRE("Vinnaren är..."),

    WINNER("Grattis %p, Du har vunnit! Spelaren hade %s poäng!"),

    WINNER_DRAW("Atans! Ingen vann! Det blev oavgjort.. Båda spelarna hade %s poäng");

    private final String text;

    Message(String text) {
        this.text = text;
    }


    String getText() {
        return text;
    }



}
