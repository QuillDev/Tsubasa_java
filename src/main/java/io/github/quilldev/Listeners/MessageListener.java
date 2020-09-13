package io.quilldev.github.Listeners;

import io.quilldev.github.BotConfig;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        //Get the messages content
        String content = event.getMessage().getContentDisplay();

        //If the author is a bot or if the content doesn't start with the prefix just stop.
        if(event.getAuthor().isBot() || content.startsWith(BotConfig.prefix)) return;

        //switch for checking command matches.
        switch(content){

        }
    }
}
