package discord.bot.mabiHelper.flow.commandManagement.service;

import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;

import java.util.List;

public interface CommandManagementService {
    //
    String register(CommandKeyword commandKeyword);

    boolean registers(List<CommandKeyword> commandKeywordList);

    void modify(CommandKeyword commandKeyword);

    void remove(CommandKeyword commandKeyword);

    CommandKeyword findById(String id);

    CommandKeyword findByKeyword(String keyword);

    List<CommandKeyword> findAllByKeywordList(List<String> keywords);

    List<CommandKeyword> findAllByContentsType(CommandType commandType);
}
