package discord.bot.mabiHelper.discord.subLogic;

import discord.bot.mabiHelper.exception.ErrorMessage;
import discord.bot.mabiHelper.flow.commandManagement.CommandManagementDiscordLogic;
import discord.bot.mabiHelper.spec.discord.DiscordMessage;
import discord.bot.mabiHelper.spec.discord.ParsingMessage;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CommandEventHandler {
    //
    @Autowired
    private CommandManagementDiscordLogic commandManagementDiscordLogic;

    @Autowired
    private MessageSendHelper messageSendHelper;

    public void sendGuideMessage(DiscordMessage discordMessage) {
        //
        TextChannel textChannel = discordMessage.getTextChannel();

        if (textChannel == null) {
            log.error(ErrorMessage.DISCORD_EXCEPTION_200.getMessage());
            return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("채팅방 봇 명령어");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setDescription("채팅방에서 사용 가능한 봇 명령어 입니다.");
        embedBuilder.addField("채팅방 대화 기록 전체 삭제", "!clear", false);
        embedBuilder.addBlankField(false);

        MessageSendHelper.sendMessage(textChannel, embedBuilder.build());
    }

    public void messageClear(DiscordMessage discordMessage) {
        //
        TextChannel textChannel = discordMessage.getTextChannel();

        if (textChannel == null) {
            log.error(ErrorMessage.DISCORD_EXCEPTION_200.getMessage());
            return;
        }

        boolean allDeleteCheck = false;

        List<String> params = Optional.of(discordMessage)
                .map(DiscordMessage::getParsingMessage)
                .map(ParsingMessage::getParameterList).orElse(null);

        if (params != null && params.size() > 0) {
            allDeleteCheck = params.get(0).equals("all");
        }

        MessageHistory history = new MessageHistory(textChannel);

        List<Message> messageList = allDeleteCheck
                ? history.getRetrievedHistory()
                : new ArrayList<>(history.getRetrievedHistory().subList(0, history.getRetrievedHistory().size()));

        if (messageList.size() > 0) {
            textChannel.deleteMessages(messageList).complete();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:dd");
        StringBuilder deleteMessage = new StringBuilder();
        deleteMessage
                .append("[")
                .append(dateFormat.format(new Date()))
                .append("] 삭제 건 수:")
                .append(messageList.size())
                .append("건");

        MessageSendHelper.sendMessage(textChannel, deleteMessage.toString());
    }

}
