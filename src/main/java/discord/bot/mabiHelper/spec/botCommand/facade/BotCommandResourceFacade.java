package discord.bot.mabiHelper.spec.botCommand.facade;

import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.sdo.BotCommandCdo;
import discord.bot.mabiHelper.spec.botCommand.sdo.BotCommandsCdo;
import discord.bot.mabiHelper.spec.keyword.sdo.SearchKeywordCdo;

public interface BotCommandResourceFacade {
    //
    String registerCommandWord(BotCommandCdo botCommandCdo);
    int registerBotCommandWords(BotCommandsCdo botCommandsCdo);
    String modifyCommandWord(SearchKeywordCdo searchKeywordCdo);
    void removeCommandWord(String commandWord);

    BotCommand findCommandByWord(String commandWord);
}
