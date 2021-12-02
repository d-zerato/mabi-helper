package discord.bot.mabiHelper.flow.simpleCommand.store;

import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;

import java.util.List;

public interface SimpleCommandStore {
    //
    String create(SimpleCommand simpleCommand);
    void creates(List<SimpleCommand> simpleCommandList);
    void update(SimpleCommand simpleCommand);
    void delete(SimpleCommand simpleCommand);

    SimpleCommand retrieveById(String id);
    SimpleCommand retrieveByKeyword(String keyword);
    List<SimpleCommand> retrieveAllByKeywordList(List<String> keywords);
    List<SimpleCommand> retrieveAllByCategory(CommandType commandType);
}
