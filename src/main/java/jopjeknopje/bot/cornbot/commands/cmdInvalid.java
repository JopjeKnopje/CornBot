package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdInvalid implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        messages.error("Invalid command!", "Command not found", event);

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
