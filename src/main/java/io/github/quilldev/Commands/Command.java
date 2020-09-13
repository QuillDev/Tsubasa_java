package io.quilldev.github.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {

    String version = "0.0.0";
    String description = "lorem ipsum";

    default void execute(MessageReceivedEvent event) {}
}
