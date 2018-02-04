package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.core.permsCore;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdPing implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage("Pong").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] Command '!ping' executed!");
    }

    @Override
    public String help() {
        return null;
    }
}
