package discord.bot.mabiHelper.discord;

import discord.bot.mabiHelper.discord.subLogic.CommandEventHandler;
import discord.bot.mabiHelper.discord.subLogic.ErrorEventHandler;
import discord.bot.mabiHelper.exception.ErrorMessage;
import discord.bot.mabiHelper.exception.ParsingMessageException;
import discord.bot.mabiHelper.flow.simpleCommand.SimpleCommandDiscordLogic;
import discord.bot.mabiHelper.spec.discord.DiscordMessage;
import discord.bot.mabiHelper.spec.discord.ParsingMessage;
import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class EventHandler {
    //
    @Autowired
    private SimpleCommandDiscordLogic simpleCommandDiscordLogic;

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

        SimpleCommand simpleCommand = simpleCommandDiscordLogic.findSimpleCommandByKeyword(command);

        if (simpleCommand == null) {
            errorEventHandler.sendErrorMessage(discordMessage, ErrorMessage.DISCORD_EXCEPTION_100);
        }

        this.parsingMessage(simpleCommand, discordMessage);
    }

    private void parsingMessage(SimpleCommand simpleCommand, DiscordMessage discordMessage) {
        //
        CommandType category = simpleCommand.getCommandType();

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
