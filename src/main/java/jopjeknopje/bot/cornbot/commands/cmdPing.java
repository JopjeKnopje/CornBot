package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.core.permsCore;
import jopjeknopje.bot.cornbot.util.STATICS;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdPing implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        long before = System.currentTimeMillis();
        Message msg = event.getChannel().sendMessage(new EmbedBuilder().setColor(STATICS.PURPLE).setDescription("Pong! ").build()).complete();
        long after = System.currentTimeMillis();
        msg.editMessage(new EmbedBuilder().setColor(STATICS.PURPLE).setTitle(":ping_pong:").setDescription("Pong! **" + (after - before + "ms**")).build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] " + event.getMember().getEffectiveName() + " executed command '!ping'");
    }

    @Override
    public String help() {
        return null;
    }
}
