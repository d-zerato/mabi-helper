package discord.bot.mabiHelper.flow.simpleCommand.service;

import discord.bot.mabiHelper.flow.simpleCommand.store.SimpleCommandStore;
import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimpleCommandServiceLogic implements SimpleCommandService {
    //
    @Autowired
    private SimpleCommandStore simpleCommandStore;

    @Override
    public String register(SimpleCommand simpleCommand) {
        //
        return simpleCommandStore.create(simpleCommand);
    }

    @Override
    public boolean registers(List<SimpleCommand> simpleCommandList) {
        if(simpleCommandList == null || simpleCommandList.size() <= 0) {
            return false;
        }

        simpleCommandStore.creates(simpleCommandList);
        return true;
    }

    @Override
    public void modify(SimpleCommand simpleCommand) {
        //
        simpleCommand.update();
        simpleCommandStore.update(simpleCommand);
    }

    @Override
    public void remove(SimpleCommand simpleCommand) {
        //
//        searchKeyword.delete();
        simpleCommandStore.delete(simpleCommand);
    }

    @Override
    public SimpleCommand findById(String id) {
        //
        return simpleCommandStore.retrieveById(id);
    }

    @Override
    public SimpleCommand findByKeyword(String keyword) {
        //
        return simpleCommandStore.retrieveByKeyword(keyword);
    }

    @Override
    public List<SimpleCommand> findAllByKeywordList(List<String> keywords) {
        //
        return simpleCommandStore.retrieveAllByKeywordList(keywords);
    }

    @Override
    public List<SimpleCommand> findAllByContentsType(CommandType commandType) {
        //
        return simpleCommandStore.retrieveAllByCategory(commandType);
    }
}
