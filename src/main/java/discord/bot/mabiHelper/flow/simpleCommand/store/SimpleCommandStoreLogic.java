package discord.bot.mabiHelper.flow.simpleCommand.store;

import discord.bot.mabiHelper.flow.simpleCommand.store.repository.SimpleCommandRepository;
import discord.bot.mabiHelper.flow.simpleCommand.store.repository.SimpleCommandJpo;
import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SimpleCommandStoreLogic implements SimpleCommandStore {
    //
    @Autowired
    private SimpleCommandRepository simpleCommandRepository;

    @Override
    public String create(SimpleCommand simpleCommand) {
        //
        simpleCommandRepository.save(new SimpleCommandJpo(simpleCommand));

        return simpleCommand.getId();
    }

    @Override
    public void creates(List<SimpleCommand> simpleCommandList) {
        //
        simpleCommandRepository.saveAll(simpleCommandList.stream().map(SimpleCommandJpo::new).collect(Collectors.toList()));
    }

    @Override
    public void update(SimpleCommand simpleCommand) {
        //
        simpleCommandRepository.save(new SimpleCommandJpo(simpleCommand));
    }

    @Override
    public void delete(SimpleCommand simpleCommand) {
        //
        simpleCommandRepository.delete(new SimpleCommandJpo(simpleCommand));
    }

    @Override
    public SimpleCommand retrieveById(String id) {
        //
        return simpleCommandRepository.findById(id).map(SimpleCommandJpo::toDomain).orElse(null);
    }

    @Override
    public SimpleCommand retrieveByKeyword(String keyword) {
        //
        return Optional.ofNullable(simpleCommandRepository.findByKeyword(keyword)).map(SimpleCommandJpo::toDomain).orElse(null);
    }

    @Override
    public List<SimpleCommand> retrieveAllByKeywordList(List<String> keywords) {
        //
        return simpleCommandRepository.findAllByKeywordInOrderByKeywordDesc(keywords).stream().map(SimpleCommandJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<SimpleCommand> retrieveAllByCategory(CommandType commandType) {
        //
        return simpleCommandRepository.findAllByCommandTypeOrderByUpdatedAtDesc(commandType).stream().map(SimpleCommandJpo::toDomain).collect(Collectors.toList());
    }
}
