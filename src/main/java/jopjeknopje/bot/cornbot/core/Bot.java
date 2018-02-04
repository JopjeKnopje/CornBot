package jopjeknopje.bot.cornbot.core;

import jopjeknopje.bot.cornbot.commands.*;
import jopjeknopje.bot.cornbot.listeners.commandListener;
import jopjeknopje.bot.cornbot.listeners.readyListener;
import jopjeknopje.bot.cornbot.listeners.voiceListener;
import jopjeknopje.bot.cornbot.util.STATICS;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Bot {

    private static JDABuilder builder;

    public static void main(String[] arguments) throws Exception {
        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(STATICS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);

        builder.setGame(new Game("") {
            @Override
            public String getName() {
                return "v" + STATICS.VERSION;
            }

            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public GameType getType() {
                return GameType.DEFAULT;
            }
        });
        addListeners();
        addCommands();


        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void addCommands() {
        commandHandler.commands.put("ping", new cmdPing());
        commandHandler.commands.put("poke", new cmdPoke());
        commandHandler.commands.put("clear", new cmdClear());
        commandHandler.commands.put("", new cmdInvalid());
        commandHandler.commands.put("speed", new cmdSpeedtest());
        commandHandler.commands.put("random", new cmdRandom());
        commandHandler.commands.put("gas", new cmdGas());
    }


    private static void addListeners() {
//        builder.addEventListener(new readyListener());
        builder.addEventListener(new voiceListener());
        builder.addEventListener(new commandListener());
    }
}
