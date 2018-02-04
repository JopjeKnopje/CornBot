package jopjeknopje.bot.cornbot.listeners;

import jopjeknopje.bot.cornbot.core.commandHandler;
import jopjeknopje.bot.cornbot.util.STATICS;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().startsWith(STATICS.PREFIX) && !event.getAuthor().isBot()) {

            commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));

        }
    }
}
