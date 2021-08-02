package discord.bot.mabiHelper.discord.subLogic;

import discord.bot.mabiHelper.exception.ErrorMessage;
import discord.bot.mabiHelper.spec.discord.DiscordMessage;
import discord.bot.mabiHelper.spec.discord.ParsingMessage;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ErrorEventHandler {
    //
    public void sendErrorMessage(DiscordMessage discordMessage, ErrorMessage errorMessage) {
        //

        TextChannel textChannel = discordMessage.getTextChannel();

        if (textChannel == null) {
            log.error(ErrorMessage.DISCORD_EXCEPTION_200.getMessage());
            return;
        }
        String message = this.failedParsingCommand(discordMessage, errorMessage);

        MessageSendHelper.sendMessage(textChannel, message);
    }

    private String failedParsingCommand(DiscordMessage discordMessage, ErrorMessage errorMessage) {
        //
        log.error("메시지 파싱 실패");
        StringBuilder resultMessage = new StringBuilder();
        if (errorMessage == ErrorMessage.DISCORD_EXCEPTION_100) {
            String inputMessage = Optional
                    .ofNullable(discordMessage)
                    .map(DiscordMessage::getParsingMessage)
                    .map(ParsingMessage::getCommand)
                    .orElse("");

            resultMessage.append("알 수 없는 명령어 입니다. : ");
            resultMessage.append(inputMessage);
            log.error(resultMessage.toString());

        } else if (errorMessage == ErrorMessage.DISCORD_EXCEPTION_101) {
            String inputMessage = Optional
                    .ofNullable(discordMessage)
                    .map(DiscordMessage::getParsingMessage)
                    .map(ParsingMessage::getCommand)
                    .orElse("");

            resultMessage.append("명령어 인자가 부족합니다.");
            resultMessage.append(inputMessage);
            log.error(resultMessage.toString());

        } else if (errorMessage == ErrorMessage.DISCORD_EXCEPTION_102) {
            String inputMessage = Optional
                    .ofNullable(discordMessage)
                    .map(DiscordMessage::getParsingMessage)
                    .map(ParsingMessage::getCommand)
                    .orElse("");

            resultMessage.append("부적절한 인자입니다.");
            resultMessage.append(inputMessage);
            log.error(resultMessage.toString());
        }

        return resultMessage.toString();
    }
}
