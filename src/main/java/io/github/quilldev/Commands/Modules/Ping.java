package io.github.quilldev.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Ping extends Command {

    //Trigger for the command
    private String trigger = "ping";
    private String description = "Get ponged!";
    private String version = "0.1";

    @Override
    public void execute(MessageReceivedEvent event){
        event.getChannel().sendMessage("Pong!").queue();
    }

    @Override
    public String getTrigger() {
        return trigger;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getVersion() {
        return version;
    }

}
