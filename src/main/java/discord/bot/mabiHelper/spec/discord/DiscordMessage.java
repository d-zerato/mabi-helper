package discord.bot.mabiHelper.spec.discord;

import discord.bot.mabiHelper.exception.ErrorMessage;
import discord.bot.mabiHelper.exception.ParsingMessageException;
import discord.bot.mabiHelper.spec.share.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscordMessage {
    //
    private User user;
    private TextChannel textChannel;
    private Message message;

    private boolean isBot;

    private ParsingMessage parsingMessage;

    public DiscordMessage(MessageReceivedEvent messageReceivedEvent) {
        //
        this.user = messageReceivedEvent.getAuthor();
        this.textChannel = messageReceivedEvent.getTextChannel();
        this.message = messageReceivedEvent.getMessage();

        this.isBot = this.user.isBot();

        this.setParsingMessage();
    }

    private void setParsingMessage() {
        //
        String command = null;
        List<String> params = new ArrayList<>();

        String message = this.message.getContentRaw();

        String[] splitTexts = message.split(" ");

        command = splitTexts[0].replace("!", "");
        boolean commandSkipPoint = false;

        for (String param : splitTexts) {
            if (!commandSkipPoint) {
                commandSkipPoint = true;
                continue;
            }

            params.add(param);
        }

        this.parsingMessage = new ParsingMessage(command, params);
    }



}
