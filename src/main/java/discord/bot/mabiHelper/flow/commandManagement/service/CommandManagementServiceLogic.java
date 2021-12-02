package discord.bot.mabiHelper.flow.commandManagement.service;

import discord.bot.mabiHelper.flow.commandManagement.store.CommandManagementStore;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandManagementServiceLogic implements CommandManagementService {
    //
    @Autowired
    private CommandManagementStore commandManagementStore;

    @Override
    public String register(CommandKeyword commandKeyword) {
        //
        return commandManagementStore.create(commandKeyword);
    }

    @Override
    public boolean registers(List<CommandKeyword> commandKeywordList) {
        if (commandKeywordList == null || commandKeywordList.size() <= 0) {
            return false;
        }

        commandManagementStore.creates(commandKeywordList);
        return true;
    }

    @Override
    public void modify(CommandKeyword commandKeyword) {
        //
        commandKeyword.update();
        commandManagementStore.update(commandKeyword);
    }

    @Override
    public void remove(CommandKeyword commandKeyword) {
        //
//        searchKeyword.delete();
        commandManagementStore.delete(commandKeyword);
    }

    @Override
    public CommandKeyword findById(String id) {
        //
        return commandManagementStore.retrieveById(id);
    }

    @Override
    public CommandKeyword findByKeyword(String keyword) {
        //
        return commandManagementStore.retrieveByKeyword(keyword);
    }

    @Override
    public List<CommandKeyword> findAllByKeywordList(List<String> keywords) {
        //
        return commandManagementStore.retrieveAllByKeywordList(keywords);
    }

    @Override
    public List<CommandKeyword> findAllByContentsType(CommandType commandType) {
        //
        return commandManagementStore.retrieveAllByCategory(commandType);
    }
}
