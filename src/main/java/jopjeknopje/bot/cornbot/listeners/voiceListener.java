package jopjeknopje.bot.cornbot.listeners;

import jopjeknopje.bot.cornbot.util.STATICS;
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
        event.getGuild().getTextChannelsByName(STATICS.LOG_CHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **joined voice channel: **" + event.getChannelJoined().getName() + "**").queue();
    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOG_CHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **moved from: **" + event.getChannelLeft().getName() + " **to: **" + event.getChannelJoined().getName() + "**").queue();

        if(event.getChannelLeft().getName().toLowerCase().equals(STATICS.GASCHAMBER_NAME) && STATICS.GAS_MEMBERS.get(event.getMember())) {
            GuildController gc = new GuildController(event.getGuild());
            gc.moveVoiceMember(event.getMember(), event.getGuild().getVoiceChannelsByName(STATICS.GASCHAMBER_NAME, true).get(0)).queue();
        }
    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOG_CHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **has left voice channel: **" + event.getChannelLeft().getName() + "**").queue();
    }

}

