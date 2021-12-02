package discord.bot.mabiHelper.flow.simpleCommand;

import discord.bot.mabiHelper.flow.simpleCommand.service.SimpleCommandService;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;;
import discord.bot.mabiHelper.spec.simpleCommand.facade.SimpleCommandResourceFacade;
import discord.bot.mabiHelper.spec.simpleCommand.sdo.SimpleCommandCdo;
import discord.bot.mabiHelper.spec.simpleCommand.sdo.SimpleCommandsCdo;
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
public class SimpleCommandFlowService extends SimpleCommandDiscordLogic implements SimpleCommandResourceFacade {
    //
    @Autowired
    private SimpleCommandService simpleCommandService;

    @Override
    public String registerSimpleCommand(SimpleCommandCdo simpleCommandCdo) {
        //
        SimpleCommand simpleCommand = this.findSimpleCommandByKeyword(simpleCommandCdo.getKeyword());

        if (simpleCommand != null) {
            log.error("Duplicate Keyword: [" + simpleCommand.getCommandType() + "]: " + simpleCommand.getKeyword());
            return null;
        }

        simpleCommand = new SimpleCommand(simpleCommandCdo.getCommandType(), simpleCommandCdo.getKeyword());

        return simpleCommandService.register(simpleCommand);
    }

    @Override
    public int registerSimpleCommands(SimpleCommandsCdo simpleCommandsCdo) {
        //
        List<SimpleCommand> simpleCommands = new ArrayList<>();

        List<SimpleCommand> duplicatedObject = simpleCommandService.findAllByKeywordList(simpleCommandsCdo.getKeywords());
        List<String> duplicatedKeyword = duplicatedObject.stream().map(SimpleCommand::getKeyword).collect(Collectors.toList());

        for (String keyword : simpleCommandsCdo.getKeywords()) {
            // 중복 체크
            if (duplicatedKeyword.contains(keyword)) {
                log.error("Duplicate Keyword: [" + simpleCommandsCdo.getCommandType().toString() + "]: " + keyword);
                continue;
            }

            SimpleCommand simpleCommand = new SimpleCommand(simpleCommandsCdo.getCommandType(), keyword);
            simpleCommands.add(simpleCommand);
        }

        simpleCommandService.registers(simpleCommands);

        return simpleCommands.size();
    }

    @Override
    public String modifySimpleCommand(String id, SimpleCommandCdo simpleCommandCdo) {
        //
        SimpleCommand simpleCommand = this.findSimpleCommandById(id);

        if (simpleCommand == null) {
            return this.registerSimpleCommand(simpleCommandCdo);
        }

        if (!simpleCommand.getCommandType().equals(simpleCommandCdo.getCommandType())) {
            simpleCommand.setCommandType(simpleCommandCdo.getCommandType());
        }

        if (!simpleCommand.getKeyword().equals(simpleCommandCdo.getKeyword())) {
            simpleCommand.setKeyword(simpleCommandCdo.getKeyword());
        }

        simpleCommandService.modify(simpleCommand);

        return id;
    }

    @Override
    public void removeSimpleCommand(String id) {
        //
        SimpleCommand simpleCommand = this.findSimpleCommandById(id);

        if (simpleCommand != null) {
            simpleCommandService.remove(simpleCommand);
        }
    }

    @Override
    public SimpleCommand findSimpleCommandById(String id) {
        //
        return simpleCommandService.findById(id);
    }
}
