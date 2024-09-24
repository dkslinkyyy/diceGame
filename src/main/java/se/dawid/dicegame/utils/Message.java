package se.dawid.dicegame.utils;

public enum Message {

    AMOUNT_OF_ROUND("Hur många rundor vill du spela mot datorn?"),
    PLAYER_JOINING("Ange ditt spelarnamn"),

    GAME_START("Då påbörjar vi spelet!"),

    ROLL_DICE("Tryck på 'enter' knappen för att kasta tärningen, Du har %s försök"),

    ROLLING("Kastar.."),

    ROLLED_DICE("Du kastade %s"),

    PC_TURN("Nu är det datorns tur!"),

    PC_ROLLED_DICE("Datorn kastade tärningen och fick %s "),

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
