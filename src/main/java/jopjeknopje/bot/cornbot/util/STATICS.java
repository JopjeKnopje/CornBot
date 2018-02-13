package jopjeknopje.bot.cornbot.util;

import net.dv8tion.jda.core.entities.Member;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class STATICS {

    private static JSONObject object;

    public static final String BOT_VERSION = "1.0.0";
    public static String BOT_TOKEN;
    public static String BOT_CHANNEL;
    public static String LOG_CHANNEL;
    public static String PREFIX;
    public static String COMMAND_ROLE;
    public static final int MAX_REMOVE = 50;
    public static int NOTIFY_DELAY;
    public static final Color PURPLE = new Color(140, 30, 160);
    public static String GASCHAMBER_NAME;
    public static final HashMap<Member, Boolean> GAS_MEMBERS = new HashMap<>();
    public static String CORNHUB_ID;
    public static final String JSON_FILE = "settings.json";


    public static void setup() {
        File file = new File(JSON_FILE);
        String content = null;
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        object = new JSONObject(content);

        object.get("token").toString();
        BOT_CHANNEL = object.get("botchannel_name").toString(); // NOT CASE SENSITIVE!
        LOG_CHANNEL = object.get("voicelog_name").toString(); // NOT CASE SENSITIVE
        PREFIX = object.get("prefix").toString();
        COMMAND_ROLE = object.get("commander_role").toString();
        NOTIFY_DELAY = intParser.getInt(object.get("notification_delay").toString());
        GASCHAMBER_NAME = object.get("gaschamber_name").toString();
        CORNHUB_ID = object.get("cornhub_id").toString();
        BOT_TOKEN = object.get("token").toString();
    }


}
