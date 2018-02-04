package jopjeknopje.bot.cornbot.core;

import jopjeknopje.bot.cornbot.util.STATICS;
import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.Route;

import javax.management.relation.Role;


/**
 * TODO: Have permission levels, level 1 can use some functions level 2 can do more etc.
 */

public class permsCore {


    public static boolean hasPermission(MessageReceivedEvent event) {
        for (net.dv8tion.jda.core.entities.Role r : event.getMember().getRoles()) {
            if(r.getName().contains(STATICS.PERMISSION)) return true;
        }

        messages.error("No permission!", event.getAuthor().getAsMention() + " you need the role: " + STATICS.PERMISSION.toLowerCase(), event);

        return false;
    }
}
