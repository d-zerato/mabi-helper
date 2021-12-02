package discord.bot.mabiHelper.spec.simpleCommand.facade;

import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;;

import java.util.List;

public interface SimpleCommandDiscordFacade {
    //
    SimpleCommand findSimpleCommandByKeyword(String keyword);
    List<SimpleCommand> findAllSimpleCommandByCommandType(CommandType commandType);
}
