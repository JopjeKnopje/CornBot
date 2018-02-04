package jopjeknopje.bot.cornbot.listeners;

import jopjeknopje.bot.cornbot.util.STATICS;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


/**
 * class used to log all the voice channel activity in a log channel on server
 */
public class voiceListener extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        event.getGuild().getTextChannelsByName(STATICS.LOGCHANNEL, true).get(0).sendMessage(
                "Member " + event.getMember().getUser().getName() + " has joined voice channel: " + event.getChannelJoined().getName()
        ).queue();

    }


    //TODO: make massage for these
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {

    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

    }


}

