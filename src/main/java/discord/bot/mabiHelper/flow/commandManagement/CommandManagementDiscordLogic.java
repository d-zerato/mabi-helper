package discord.bot.mabiHelper.flow.commandManagement;

import discord.bot.mabiHelper.flow.commandManagement.service.CommandManagementService;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import discord.bot.mabiHelper.spec.commandManagement.facade.CommandManagementDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommandManagementDiscordLogic implements CommandManagementDiscordFacade {
    //
    @Autowired
    private CommandManagementService commandManagementService;

    @Override
    public CommandKeyword findSimpleCommandByKeyword(String keyword) {
        //
        return commandManagementService.findByKeyword(keyword);
    }

    @Override
    public List<CommandKeyword> findAllSimpleCommandByCommandType(CommandType commandType) {
        //
        return commandManagementService.findAllByContentsType(commandType);
    }
}
