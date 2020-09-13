package io.quilldev.github;

import io.quilldev.github.JSON.JSONLoader;
import org.json.JSONObject;

public class BotConfig {

    //Load the config
    private static JSONObject config = new JSONLoader("config.json").load();

    //Get items from the config
    public static String token = config.get("token").toString();
    public static String prefix = config.get("prefix").toString();
}
