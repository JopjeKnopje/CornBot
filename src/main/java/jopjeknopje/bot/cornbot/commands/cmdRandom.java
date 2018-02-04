package jopjeknopje.bot.cornbot.commands;

import jopjeknopje.bot.cornbot.util.intParser;
import jopjeknopje.bot.cornbot.util.messages;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Random;

public class cmdRandom implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Random rand = new Random();

        int minValue = 0;
        int maxValue = 1;
        int result;

//        System.out.println(args.length);
        switch (args.length) {
            case 1:
                maxValue = intParser.getInt(args[0]);
                result = rand.nextInt(maxValue - minValue + 1);
                break;

            case 2:
                maxValue = intParser.getInt(args[0]);
                minValue = intParser.getInt(args[1]);
                result = minValue + rand.nextInt(maxValue - minValue + 1);
                break;
            default:
                result = rand.nextInt(maxValue - minValue + 1);
                break;
        }

        messages.notification("Random", Integer.toString(result), event);

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
