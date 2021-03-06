package jopjeknopje.bot.cornbot.util;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class messages {



    public static void sendPrivateMessage(User user, String content) {
        user.openPrivateChannel().queue((channel) -> {
            channel.sendMessage(content).queue();
        });
    }

    public static void error(String title, String content, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(Color.red).setTitle("**" + ":loudspeaker: " + title + "**").setDescription(content).build()).queue();
    }


    public static void notification(String title, String content, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder()
                .setColor(STATICS.PURPLE)
                .setTitle("**" + ":loudspeaker: " + title + "**")
                .setDescription(content)
                .build()).queue();

    }

    public static void notification(String title, String content, int delay, MessageReceivedEvent event) {
        Message msg = event.getTextChannel().sendMessage(new EmbedBuilder()
                .setColor(STATICS.PURPLE)
                .setTitle("**" + ":loudspeaker: " + title + "**")
                .setDescription(content)
                .build()).complete();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                msg.delete().queue();
            }
        }, delay);
    }

    public static void notification(String title, String content, TextChannel channel) {
        channel.sendMessage(new EmbedBuilder()
                .setColor(STATICS.PURPLE)
                .setTitle("**" + ":loudspeaker: " + title + "**")
                .setDescription(content)
                .build()).queue();
    }

    public static void sendImage(String title, String image, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder()
                .setColor(STATICS.PURPLE)
                .setTitle("**:frame_photo: " + title + "**")
                .setImage(image)
                .build()).queue();
    }
}
