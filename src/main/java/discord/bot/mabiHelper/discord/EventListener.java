package discord.bot.mabiHelper.discord;

import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventListener extends ListenerAdapter {
    //
    @Autowired
    private EventHandler eventHandler;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        //
        // 봇 커맨드 여부 판단
//        boolean commandCheck = Optional
//                .of(event)
//                .map(MessageReceivedEvent::getMessage)
//                .map(Message::getContentRaw)
//                .map(contents -> {
//                    return contents.charAt(0) == '!';
//                })
//                .orElse(false);
//
//        if (!commandCheck) {
//            return;
//        }
//        // 메시지 및 채널 구성
//        DiscordMessage discordMessage = new DiscordMessage(event);
//
//        eventHandler.messageHandling(discordMessage);
    }

    public void onSlashCommand(SlashCommandEvent event) {
        //
        if (event.getGuild() == null) {
            return;
        }

        CommandType inputType = CommandType.valueOf(event.getName());

        switch (inputType) {
            case MASTER:
                System.out.println("SlashEventTest : Test");
                break;
        }
    }
}
