package jopjeknopje.bot.cornbot.audioCore;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

public class AudioInfo {

    private final AudioTrack TRACK;
    private final Member AUTHOR;

    AudioInfo(AudioTrack track, Member author) {
        AUTHOR = author;
        TRACK = track;
    }

    public AudioTrack getTrack() {
        return TRACK;
    }

    public Member getAuthor() {
        return AUTHOR;
    }
}
