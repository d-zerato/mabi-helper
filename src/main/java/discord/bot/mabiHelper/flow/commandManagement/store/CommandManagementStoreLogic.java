package discord.bot.mabiHelper.flow.commandManagement.store;

import discord.bot.mabiHelper.flow.commandManagement.store.repository.CommandKeywordInfoJpo;
import discord.bot.mabiHelper.flow.commandManagement.store.repository.CommandManagementRepository;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CommandManagementStoreLogic implements CommandManagementStore {
    //
    @Autowired
    private CommandManagementRepository commandManagementRepository;

    @Override
    public String create(CommandKeyword commandKeyword) {
        //
        commandManagementRepository.save(new CommandKeywordInfoJpo(commandKeyword));

        return commandKeyword.getId();
    }

    @Override
    public void creates(List<CommandKeyword> commandKeywordList) {
        //
        commandManagementRepository.saveAll(commandKeywordList.stream().map(CommandKeywordInfoJpo::new).collect(Collectors.toList()));
    }

    @Override
    public void update(CommandKeyword commandKeyword) {
        //
        commandManagementRepository.save(new CommandKeywordInfoJpo(commandKeyword));
    }

    @Override
    public void delete(CommandKeyword commandKeyword) {
        //
        commandManagementRepository.delete(new CommandKeywordInfoJpo(commandKeyword));
    }

    @Override
    public CommandKeyword retrieveById(String id) {
        //
        return commandManagementRepository.findById(id).map(CommandKeywordInfoJpo::toDomain).orElse(null);
    }

    @Override
    public CommandKeyword retrieveByKeyword(String keyword) {
        //
        return Optional.ofNullable(commandManagementRepository.findByKeyword(keyword)).map(CommandKeywordInfoJpo::toDomain).orElse(null);
    }

    @Override
    public List<CommandKeyword> retrieveAllByKeywordList(List<String> keywords) {
        //
        return commandManagementRepository.findAllByKeywordInOrderByKeywordDesc(keywords).stream().map(CommandKeywordInfoJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<CommandKeyword> retrieveAllByCategory(CommandType commandType) {
        //
        return commandManagementRepository.findAllByCommandTypeOrderByUpdatedAtDesc(commandType).stream().map(CommandKeywordInfoJpo::toDomain).collect(Collectors.toList());
    }
}
