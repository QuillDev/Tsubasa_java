package io.quilldev.github;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;

import javax.security.auth.login.LoginException;

public class Tsubasa {

    public static void main(String[] args){
        //Get the token from the config
        String token = BotConfig.token;

        //Create a JDA builder for building the Discord API
        JDABuilder builder = JDABuilder.createDefault(token); //create the builder using the token
        builder.setCompression(Compression.ZLIB); //set builder compression to zlib
        builder.setActivity(Activity.of(Activity.ActivityType.DEFAULT, "io.quilldev.github.Tsubasa v0.1")); //set the bots activity

        //Try to build
        try {
            builder.build();
        }
        //Catch a login exception of it occurs
        catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
