package discord.bot.mabiHelper.spec.botCommand.facade;

import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;

import java.util.List;

public interface BotCommandDiscordFacade {
    //
    BotCommand findDiscordCommandByword(String commandWord);
    List<BotCommand> findAllByCategory(CommandCategory category);
}
