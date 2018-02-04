package jopjeknopje.bot.cornbot.listeners;

import jopjeknopje.bot.cornbot.util.STATICS;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String out = "Ready, running on the following servers: ";

        for (Guild g: event.getJDA().getGuilds()) {
            out += "'" + g.getName() + "' (" + g.getId() + ") \n";
        }

        System.out.println(out);

        try {
            for (Guild g: event.getJDA().getGuilds()) {
                g.getTextChannelsByName(STATICS.BOTCHANNEL, true).get(0).sendMessage(new EmbedBuilder().setColor(Color.BLUE).setDescription("I'm Baaaack").build()).queue();

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception");
        }

    }

}
