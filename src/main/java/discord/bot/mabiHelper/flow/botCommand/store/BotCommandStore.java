package discord.bot.mabiHelper.flow.botCommand.store;

import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;

import java.util.List;

public interface BotCommandStore {
    //
    String create(BotCommand botCommand);
    void creates(List<BotCommand> botCommandList);
    void update(BotCommand botCommand);
    void delete(BotCommand botCommand);

    BotCommand retrieveById(String id);
    BotCommand retrieveByWord(String commandWord);
    List<BotCommand> retrieveAllByWordList(List<String> wordList);
    List<BotCommand> retrieveAllByCategory(CommandCategory commandCategory);
}
