package jopjeknopje.bot.cornbot.util;

public class intParser {

    public static int getInt(String str) {
        try {
            return Integer.parseInt(str);

        } catch (NumberFormatException e) {
            return 0;
        }

    }

}
