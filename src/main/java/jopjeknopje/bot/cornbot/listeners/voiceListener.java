package jopjeknopje.bot.cornbot.listeners;

import jopjeknopje.bot.cornbot.util.STATICS;
import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


/**
 * class used to log all the voice channel activity in a log channel on server
 */
public class voiceListener extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **joined voice channel: **" + event.getChannelJoined().getName() + "**").queue();
    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **moved from: **" + event.getChannelLeft().getName() + " **to: **" + event.getChannelJoined().getName() + "**").queue();
    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage("**:loudspeaker: Voice update " + event.getMember().getUser().getName() + " **has left voice channel: **" + event.getChannelLeft().getName() + "**").queue();
    }

}

