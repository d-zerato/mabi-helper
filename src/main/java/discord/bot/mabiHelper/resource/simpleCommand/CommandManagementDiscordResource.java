package discord.bot.mabiHelper.resource.simpleCommand;

import discord.bot.mabiHelper.flow.commandManagement.CommandManagementDiscordLogic;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import discord.bot.mabiHelper.spec.commandManagement.facade.CommandManagementDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mabinogi/discord/keyword")
public class CommandManagementDiscordResource implements CommandManagementDiscordFacade {
    //
    @Autowired
    private CommandManagementDiscordLogic commandManagementDiscordLogic;

    @Override
    @GetMapping("/{keyword}")
    public CommandKeyword findSimpleCommandByKeyword(@PathVariable(name = "keyword") String keyword) {
        //
        return commandManagementDiscordLogic.findSimpleCommandByKeyword(keyword);
    }

    @Override
    @GetMapping("/all/{type}")
    public List<CommandKeyword> findAllSimpleCommandByCommandType(@PathVariable(name = "type") CommandType commandType) {
        //
        return commandManagementDiscordLogic.findAllSimpleCommandByCommandType(commandType);
    }
}
