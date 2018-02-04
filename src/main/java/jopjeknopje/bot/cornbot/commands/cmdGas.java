package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.core.permsCore;
import jopjeknopje.bot.cornbot.util.STATICS;
import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;

public class cmdGas implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(!permsCore.hasPermission(event)) return;
        VoiceChannel vc = event.getGuild().getVoiceChannelsByName(STATICS.GASCHAMBER_NAME, true).get(0);
        GuildController gc = new GuildController(event.getGuild());

        switch (args.length) {
            case 1:
                gc.moveVoiceMember(event.getMessage().getMentionedMembers().get(0), vc).queue();
                break;
            case 2:
                if(args[1].equals("toggle")) {
                    //TODO store user in map
                    //TODO left off here
                    STATICS.GAS_MEMBERS.put(event.getMessage().getMentionedMembers().get(0), true);
                    Boolean temp = STATICS.GAS_MEMBERS.get(event.getMessage().getMentionedMembers().get(0));

                    System.out.println(temp);


                    gc.moveVoiceMember(event.getMessage().getMentionedMembers().get(0), vc).queue();
                }
                break;

            default:
                messages.error("Invalid argument", "You need to specify a user to gas", event);
                break;
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
