package discord.bot.mabiHelper.flow.botCommand.service;

import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;

import java.util.List;

public interface BotCommandService {
    //
    String register(BotCommand botCommand);
    boolean registers(List<BotCommand> botCommandList);
    void modify(BotCommand botCommand);
    void remove(BotCommand botCommand);

    BotCommand findById(String id);
    BotCommand findByWord(String commandWord);
    List<BotCommand> findAllBywordList(List<String> wordList);
    List<BotCommand> findAllByCommandCategory(CommandCategory commandCategory);
}
