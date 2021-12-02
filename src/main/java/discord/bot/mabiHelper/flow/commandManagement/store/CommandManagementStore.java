package discord.bot.mabiHelper.flow.commandManagement.store;

import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;

import java.util.List;

public interface CommandManagementStore {
    //
    String create(CommandKeyword commandKeyword);

    void creates(List<CommandKeyword> commandKeywordList);

    void update(CommandKeyword commandKeyword);

    void delete(CommandKeyword commandKeyword);

    CommandKeyword retrieveById(String id);

    CommandKeyword retrieveByKeyword(String keyword);

    List<CommandKeyword> retrieveAllByKeywordList(List<String> keywords);

    List<CommandKeyword> retrieveAllByCategory(CommandType commandType);
}
