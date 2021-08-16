package discord.bot.mabiHelper.spec.botCommand.sdo;

import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import discord.bot.mabiHelper.spec.botCommand.CommandType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BotCommandsCdo {
    //
    private List<String> commandWords;
    private CommandCategory commandCategory;
    private CommandType commandType;
}
