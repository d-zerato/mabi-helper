package discord.bot.mabiHelper.resource.simpleCommand;

import discord.bot.mabiHelper.flow.simpleCommand.SimpleCommandDiscordLogic;
import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;
import discord.bot.mabiHelper.spec.simpleCommand.facade.SimpleCommandDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mabinogi/discord/keyword")
public class SimpleCommandDiscordResource implements SimpleCommandDiscordFacade {
    //
    @Autowired
    private SimpleCommandDiscordLogic simpleCommandDiscordLogic;

    @Override
    @GetMapping("/{keyword}")
    public SimpleCommand findSimpleCommandByKeyword(@PathVariable(name="keyword") String keyword) {
        //
        return simpleCommandDiscordLogic.findSimpleCommandByKeyword(keyword);
    }

    @Override
    @GetMapping("/all/{type}")
    public List<SimpleCommand> findAllSimpleCommandByCommandType(@PathVariable(name="type") CommandType commandType) {
        //
        return simpleCommandDiscordLogic.findAllSimpleCommandByCommandType(commandType);
    }
}
