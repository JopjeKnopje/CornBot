package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.core.permsCore;
import jopjeknopje.bot.cornbot.util.STATICS;
import jopjeknopje.bot.cornbot.util.intParser;
import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO: Add permission check
 */
public class cmdClear implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        if(!permsCore.hasPermission(event)) return;

        if(args.length < 1) {
            messages.error("Invalid argument!", "You must enter a number between 2 and " + STATICS.MAXREMOVE, event);
            return;
        }


        int amount = intParser.getInt(args[0]);
//        System.out.println(amount); // for debugging
        if(amount >= 2 && amount <= STATICS.MAXREMOVE) {
            amount++;


            MessageHistory history = new MessageHistory(event.getTextChannel());
            List<Message> msgs;

            msgs = history.retrievePast(amount).complete();
            event.getTextChannel().deleteMessages(msgs).queue();

            messages.notification("", "Just removed " + (amount - 1) +" messages", STATICS.NOTIFY_DELAY, event);

        }

        else {
            messages.error("Invalid argument!", "You must enter a number between 2 and " + STATICS.MAXREMOVE, event);
            return;
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
