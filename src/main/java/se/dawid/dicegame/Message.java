package se.dawid.dicegame;

public enum Message {

    ROLL_DICE("Skriv 'roll' för att kasta tärningen, Du har %s försök"),

    ROLLED_DICE("Du kastade %s"),

    NEXT_TURN("Näst på tur %p"),

    NEXT_PLAYER("Byter till nästa spelare!"),

    PLAYER_JOINED("%p är nu med i spelet."),

    PLAYER_JOINING("Ange namn på spelare"),

    TOTAL_POINTS("Det totala utfallet blev %s"),

    WINNER_PRE("Vinnaren är..."),
    WINNER("Grattis %p, Du har vunnit! Spelaren hade %s poäng!");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public Message print(String... values) {
        String formatted = text;

        for(String value : values) {

            if (formatted.contains("%p")) {
                formatted = formatted.replaceAll("%p", value).replaceAll("%n", "\n");

            } else if (formatted.contains("%s")) {
                formatted = formatted.replaceAll("%s", value);
            }


        }

        System.out.println(formatted);
        return this;
    }



}
