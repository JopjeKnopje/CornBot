package jopjeknopje.bot.cornbot.listeners;

import jopjeknopje.bot.cornbot.util.STATICS;
import jopjeknopje.bot.cornbot.util.gasMember;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;


/**
 * class used to log all the voice channel activity in a log channel on server
 */

public class voiceListener extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **joined voice channel: **" + event.getChannelJoined().getName() + "**").queue();
    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **moved from: **" + event.getChannelLeft().getName() + " **to: **" + event.getChannelJoined().getName() + "**").queue();


        System.out.println(STATICS.);

        //TODO: Check if hashmap if person should be gassed

//        if(event.getChannelLeft().getName().toLowerCase().equals(STATICS.GASCHAMBER_NAME) && event.getMember().equals(GLOBALS.GAS_MEMBER) && GLOBALS.GAS_MEMBER_BOOL) {
//            GuildController gc = new GuildController(event.getGuild());
//            gc.moveVoiceMember(event.getMember(), event.getGuild().getVoiceChannelsByName(STATICS.GASCHAMBER_NAME, true).get(0)).queue();
//        }
    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **has left voice channel: **" + event.getChannelLeft().getName() + "**").queue();
    }

}

