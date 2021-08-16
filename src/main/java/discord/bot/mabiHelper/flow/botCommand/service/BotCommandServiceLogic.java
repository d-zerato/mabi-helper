package discord.bot.mabiHelper.flow.botCommand.service;

import discord.bot.mabiHelper.flow.botCommand.store.BotCommandStore;
import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BotCommandServiceLogic implements BotCommandService {
    //
    @Autowired
    private BotCommandStore botCommandStore;

    @Override
    public String register(BotCommand botCommand) {
        //
        return botCommandStore.create(botCommand);
    }

    @Override
    public boolean registers(List<BotCommand> botCommandList) {
        //
        if (botCommandList == null && botCommandList.size() <= 0) {
            return false;
        }

        botCommandStore.creates(botCommandList);
        return true;
    }

    @Override
    public void modify(BotCommand botCommand) {
        //
        botCommandStore.update(botCommand);
    }

    @Override
    public void remove(BotCommand botCommand) {
        //
        botCommandStore.delete(botCommand);
    }

    @Override
    public BotCommand findById(String id) {
        //
        return botCommandStore.retrieveById(id);
    }

    @Override
    public BotCommand findByWord(String commandWord) {
        //
        return botCommandStore.retrieveByWord(commandWord);
    }

    @Override
    public List<BotCommand> findAllBywordList(List<String> wordList) {
        //
        return botCommandStore.retrieveAllByWordList(wordList);
    }

    @Override
    public List<BotCommand> findAllByCommandCategory(CommandCategory commandCategory) {
        //
        return botCommandStore.retrieveAllByCategory(commandCategory);
    }
}
