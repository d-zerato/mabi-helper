package discord.bot.mabiHelper.flow.botCommand.store;

import discord.bot.mabiHelper.flow.botCommand.store.repository.BotCommandJpo;
import discord.bot.mabiHelper.flow.botCommand.store.repository.BotCommandRepository;
import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BotCommandStoreLogic implements BotCommandStore {
    //
    @Autowired
    private BotCommandRepository botCommandRepository;

    @Override
    public String create(BotCommand botCommand) {
        //
        botCommandRepository.save(new BotCommandJpo(botCommand));

        return botCommand.getId();
    }

    @Override
    public void creates(List<BotCommand> botCommandList) {
        //
        botCommandRepository.saveAll(botCommandList.stream().map(BotCommandJpo::new).collect(Collectors.toList()));
    }

    @Override
    public void update(BotCommand botCommand) {
        //
        botCommandRepository.save(new BotCommandJpo(botCommand));
    }

    @Override
    public void delete(BotCommand botCommand) {
        //
        botCommandRepository.delete(new BotCommandJpo(botCommand));
    }

    @Override
    public BotCommand retrieveById(String id) {
        //
        return botCommandRepository.findById(id).map(BotCommandJpo::toDomain).orElse(null);
    }

    @Override
    public BotCommand retrieveByWord(String word) {
        //
        return Optional.ofNullable(botCommandRepository.findByCommandWord(word)).map(BotCommandJpo::toDomain).orElse(null);
    }

    @Override
    public List<BotCommand> retrieveAllByWordList(List<String> wordList) {
        //
        return botCommandRepository.findAllByCommandWordInOrderByCreatedAtDesc(wordList).stream().map(BotCommandJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<BotCommand> retrieveAllByCategory(CommandCategory commandCategory) {
        //
        return botCommandRepository.findAllByCommandCategoryOrderByCreatedAtDesc(commandCategory).stream().map(BotCommandJpo::toDomain).collect(Collectors.toList());
    }
}
