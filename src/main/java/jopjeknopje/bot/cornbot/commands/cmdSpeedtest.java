package jopjeknopje.bot.cornbot.commands;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.SpeedTestSocket;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;
import jopjeknopje.bot.cornbot.core.permsCore;
import jopjeknopje.bot.cornbot.util.STATICS;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdSpeedtest implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(!permsCore.hasPermission(event)) return;

        SpeedTestSocket downSpeed = new SpeedTestSocket();
        SpeedTestSocket upSpeed = new SpeedTestSocket();
        StringBuilder sb = new StringBuilder();

        Message msg = event.getTextChannel().sendMessage(new EmbedBuilder().setColor(STATICS.PURPLE).setDescription("**:loudspeaker: Speed test running...**\n\nTesting downstream with 10MB file...").build()).complete();

        downSpeed.addSpeedTestListener(new ISpeedTestListener() {
            @Override
            public void onCompletion(SpeedTestReport report) {
                sb.append("Downstream:  " + (report.getTransferRateBit().floatValue() / 1024 / 1024) + " MBit/s\n");
                msg.editMessage(new EmbedBuilder().setColor(new Color(123, 39, 163)).setDescription("**:loudspeaker: Speed test running...**\n\nTesting upstream with 1MB file...").build()).queue();
                upSpeed.startUpload("http://2.testdebit.info/", 1000000);
            }

            @Override
            public void onProgress(float percent, SpeedTestReport report) {
            }

            @Override
            public void onError(SpeedTestError speedTestError, String s) {
                System.out.println(speedTestError);
            }

        });

        upSpeed.addSpeedTestListener(new ISpeedTestListener() {
            @Override
            public void onCompletion(SpeedTestReport report) {
                sb.append("Upstream:    " + (report.getTransferRateBit().floatValue() / 1024 / 1024) + " MBit/s");
                msg.editMessage(new EmbedBuilder().setColor(new Color(123, 39, 163)).setDescription("**:loudspeaker: Speed test finished**.\n\n```" + sb.toString() + "```").build()).queue();
            }

            @Override
            public void onProgress(float v, SpeedTestReport speedTestReport) {

            }

            @Override
            public void onError(SpeedTestError speedTestError, String s) {
                System.out.println(speedTestError);
            }

        });

        downSpeed.startDownload("http://2.testdebit.info/10M.iso");
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
