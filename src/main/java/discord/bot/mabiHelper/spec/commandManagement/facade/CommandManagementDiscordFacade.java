package discord.bot.mabiHelper.spec.commandManagement.facade;

import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;

import java.util.List;

public interface CommandManagementDiscordFacade {
    //
    CommandKeyword findSimpleCommandByKeyword(String keyword);

    List<CommandKeyword> findAllSimpleCommandByCommandType(CommandType commandType);
}
