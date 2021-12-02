package discord.bot.mabiHelper.discord;

import discord.bot.mabiHelper.discord.subLogic.CommandEventHandler;
import discord.bot.mabiHelper.discord.subLogic.ErrorEventHandler;
import discord.bot.mabiHelper.exception.ErrorMessage;
import discord.bot.mabiHelper.exception.ParsingMessageException;
import discord.bot.mabiHelper.flow.commandManagement.CommandManagementDiscordLogic;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import discord.bot.mabiHelper.spec.discord.DiscordMessage;
import discord.bot.mabiHelper.spec.discord.ParsingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class EventHandler {
    //
    @Autowired
    private CommandManagementDiscordLogic commandManagementDiscordLogic;

    @Autowired
    private ErrorEventHandler errorEventHandler;

    @Autowired
    private CommandEventHandler commandEventHandler;

    public void messageHandling(DiscordMessage discordMessage) throws ParsingMessageException {
        //
        String command = Optional.ofNullable(discordMessage)
                .map(DiscordMessage::getParsingMessage)
                .map(ParsingMessage::getCommand)
                .orElse(null);

        if (command == null) {
            errorEventHandler.sendErrorMessage(discordMessage, ErrorMessage.DISCORD_EXCEPTION_100);
        }

        CommandKeyword commandKeyword = commandManagementDiscordLogic.findSimpleCommandByKeyword(command);

        if (commandKeyword == null) {
            errorEventHandler.sendErrorMessage(discordMessage, ErrorMessage.DISCORD_EXCEPTION_100);
        }

        this.parsingMessage(commandKeyword, discordMessage);
    }

    private void parsingMessage(CommandKeyword commandKeyword, DiscordMessage discordMessage) {
        //
        CommandType category = commandKeyword.getCommandType();

        switch (category) {
            case CLEAR_MESSAGE:
                commandEventHandler.messageClear(discordMessage);
                break;
            case COMMAND_GUIDE:
                commandEventHandler.sendGuideMessage(discordMessage);
                break;
            default:
                break;
        }
    }

}
