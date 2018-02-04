package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdPoke implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String out = "";

        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                out += args[i] + " ";
            }
//            System.out.println(out); // Debug
        }
        messages.sendPrivateMessage(event.getMessage().getMentionedUsers().get(0), ":speaker: " + event.getMessage().getAuthor().getAsMention() + " Poked you. " + out);
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        // TODO: add help
        return null;
    }



}
