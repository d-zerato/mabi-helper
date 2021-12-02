package discord.bot.mabiHelper.flow.commandManagement;

import discord.bot.mabiHelper.flow.commandManagement.service.CommandManagementService;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.facade.CommandManagementResourceFacade;
import discord.bot.mabiHelper.spec.commandManagement.sdo.SimpleCommandCdo;
import discord.bot.mabiHelper.spec.commandManagement.sdo.SimpleCommandsCdo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class CommandManagementFlowService extends CommandManagementDiscordLogic implements CommandManagementResourceFacade {
    //
    @Autowired
    private CommandManagementService commandManagementService;

    @Override
    public String registerSimpleCommand(SimpleCommandCdo simpleCommandCdo) {
        //
        CommandKeyword commandKeyword = this.findSimpleCommandByKeyword(simpleCommandCdo.getKeyword());

        if (commandKeyword != null) {
            log.error("Duplicate Keyword: [" + commandKeyword.getCommandType() + "]: " + commandKeyword.getKeyword());
            return null;
        }

        commandKeyword = new CommandKeyword(simpleCommandCdo.getCommandType(), simpleCommandCdo.getKeyword());

        return commandManagementService.register(commandKeyword);
    }

    @Override
    public int registerSimpleCommands(SimpleCommandsCdo simpleCommandsCdo) {
        //
        List<CommandKeyword> commandKeywords = new ArrayList<>();

        List<CommandKeyword> duplicatedObject = commandManagementService.findAllByKeywordList(simpleCommandsCdo.getKeywords());
        List<String> duplicatedKeyword = duplicatedObject.stream().map(CommandKeyword::getKeyword).collect(Collectors.toList());

        for (String keyword : simpleCommandsCdo.getKeywords()) {
            // 중복 체크
            if (duplicatedKeyword.contains(keyword)) {
                log.error("Duplicate Keyword: [" + simpleCommandsCdo.getCommandType().toString() + "]: " + keyword);
                continue;
            }

            CommandKeyword commandKeyword = new CommandKeyword(simpleCommandsCdo.getCommandType(), keyword);
            commandKeywords.add(commandKeyword);
        }

        commandManagementService.registers(commandKeywords);

        return commandKeywords.size();
    }

    @Override
    public String modifySimpleCommand(String id, SimpleCommandCdo simpleCommandCdo) {
        //
        CommandKeyword commandKeyword = this.findSimpleCommandById(id);

        if (commandKeyword == null) {
            return this.registerSimpleCommand(simpleCommandCdo);
        }

        if (!commandKeyword.getCommandType().equals(simpleCommandCdo.getCommandType())) {
            commandKeyword.setCommandType(simpleCommandCdo.getCommandType());
        }

        if (!commandKeyword.getKeyword().equals(simpleCommandCdo.getKeyword())) {
            commandKeyword.setKeyword(simpleCommandCdo.getKeyword());
        }

        commandManagementService.modify(commandKeyword);

        return id;
    }

    @Override
    public void removeSimpleCommand(String id) {
        //
        CommandKeyword commandKeyword = this.findSimpleCommandById(id);

        if (commandKeyword != null) {
            commandManagementService.remove(commandKeyword);
        }
    }

    @Override
    public CommandKeyword findSimpleCommandById(String id) {
        //
        return commandManagementService.findById(id);
    }
}
