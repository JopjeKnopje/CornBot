package jopjeknopje.bot.cornbot;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import jopjeknopje.bot.cornbot.audio.AudioPlayerSendHandler;
import jopjeknopje.bot.cornbot.audio.GuildMusicManager;
import jopjeknopje.bot.cornbot.audio.TrackScheduler;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

import java.awt.*;
import java.util.Map;

public class Test extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (!event.getMessage().getContentRaw().startsWith("!test")) return;


        if (!event.getMessage().getContentRaw().startsWith("!test ")) {
            event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.RED).setDescription("Error: no arguments given").build()).queue();
            return;
        }

        String args = event.getMessage().getContentRaw().split(" ")[1];
        System.out.println(args);

        Guild guild = event.getGuild();
        VoiceChannel vc = guild.getVoiceChannelsByName(args, true).get(0);

        AudioManager audioManager = guild.getAudioManager();


        AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);

        AudioPlayer player = playerManager.createPlayer();

        TrackScheduler trackScheduler = new TrackScheduler(player);
        player.addListener(trackScheduler);

        playerManager.loadItem("https://www.youtube.com/watch?v=4LfJnj66HVQ", new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                trackScheduler.queue(track);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                for (AudioTrack track : playlist.getTracks()) {
                    trackScheduler.queue(track);
                }
            }

            @Override
            public void noMatches() {

            }

            @Override
            public void loadFailed(FriendlyException exception) {

            }
        });

        audioManager.openAudioConnection(vc);
        player.playTrack(playerManagerg);


    }

}
