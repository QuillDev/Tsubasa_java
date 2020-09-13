package io.github.quilldev.Listeners;

import io.github.quilldev.BotConfig;
import io.github.quilldev.Commands.CommandManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class MessageListener extends ListenerAdapter {

    private final CommandManager commandManager = CommandManager.getInstance();
    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        //Get the messages content
        String content = event.getMessage().getContentDisplay();

        //If the author is a bot or if the content doesn't start with the prefix just stop.
        if(event.getAuthor().isBot() || !content.startsWith(BotConfig.prefix)) return;

        //Find the command
        commandManager.findCommand(event);
    }
}
