package discord.bot.mabiHelper.spec.simpleCommand.sdo;

import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SimpleCommandsCdo {
    //
    private CommandType commandType;
    private List<String> keywords;
}
