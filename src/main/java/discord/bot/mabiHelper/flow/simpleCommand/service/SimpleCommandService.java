package discord.bot.mabiHelper.flow.simpleCommand.service;

import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;;

import java.util.List;

public interface SimpleCommandService {
    //
    String register(SimpleCommand simpleCommand);
    boolean registers(List<SimpleCommand> simpleCommandList);
    void modify(SimpleCommand simpleCommand);
    void remove(SimpleCommand simpleCommand);

    SimpleCommand findById(String id);
    SimpleCommand findByKeyword(String keyword);
    List<SimpleCommand> findAllByKeywordList(List<String> keywords);
    List<SimpleCommand> findAllByContentsType(CommandType commandType);
}
