package discord.bot.mabiHelper.spec.commandManagement.sdo;

import discord.bot.mabiHelper.spec.commandManagement.CommandType;
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
