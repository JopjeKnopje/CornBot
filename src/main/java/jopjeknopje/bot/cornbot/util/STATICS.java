package jopjeknopje.bot.cornbot.util;

import net.dv8tion.jda.core.entities.Member;

import java.awt.*;
import java.util.HashMap;

public class STATICS {

    public static final String BOT_VERSION = "1.0.0";
    public static final String BOT_TOKEN = "";
    public static final String BOT_CHANNEL = "bot-spam"; // NOT CASE SENSITIVE!
    public static final String LOG_CHANNEL = "voicelog"; // NOT CASE SENSITIVE!
    public static final String PREFIX = "~";
    public static final String COMMAND_ROLE = "BOT-COMMANDER";
    public static final int MAX_REMOVE = 50;
    public static final int NOTIFY_DELAY = 1500;
    public static final Color PURPLE = new Color(140, 30, 160);
    public static final String GASCHAMBER_NAME = "gas chamber";
    public static final HashMap<Member, Boolean> GAS_MEMBERS = new HashMap<>();
    public static final String CORNHUB_ID = "237145255760232450";
    public static final String JSONFILE = "settings.json";
}
