package jopjeknopje.bot.cornbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Bot {
    private static JDA api;


    public static void main(String[] arguments) throws Exception {
        api = new JDABuilder(AccountType.BOT)
                .setToken("MjkxMzA1NjQwNzQyMjIzODcy.DVTqww.atuPR5JLUgqT6tLEoK5Yx-nbG9g")
                .addEventListener(new Ping())
                .addEventListener(new Test())
                .buildAsync();

    }


}
