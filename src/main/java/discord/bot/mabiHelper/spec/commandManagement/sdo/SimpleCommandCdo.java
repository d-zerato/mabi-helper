package discord.bot.mabiHelper.spec.commandManagement.sdo;

import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCommandCdo {
    //
    private String keyword;
    private CommandType commandType;
}
