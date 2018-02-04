package jopjeknopje.bot.cornbot.core;

import jopjeknopje.bot.cornbot.commands.Command;

import java.util.HashMap;

public class commandHandler {

    public static final commandParser parse = new commandParser();
    // command lookup table
    public static HashMap<String, Command> commands = new HashMap<>();


    public static void handleCommand(commandParser.commandContainer cmd) {


        // Check if the command exists
        if (commands.containsKey(cmd.invoke)) {

            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (!safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);

            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }

        }

    }

}