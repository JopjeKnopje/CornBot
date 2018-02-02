package jopjeknopje.bot.cornbot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Ping extends ListenerAdapter
{

    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getMessage().getContentRaw().equals("!ping"))
        {
            long ping = event.getJDA().getPing();
            event.getTextChannel().sendMessage(new EmbedBuilder().setColor(getColorByPing(ping)).setDescription("Pong! " + ping + "ms").build()).queue();


        }

    }

    private Color getColorByPing(long ping) {
        if (ping < 100)
            return Color.cyan;
        if (ping < 400)
            return Color.green;
        if (ping < 700)
            return Color.yellow;
        if (ping < 1000)
            return Color.orange;
        return Color.red;
    }



}
