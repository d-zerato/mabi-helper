package discord.bot.mabiHelper.flow.simpleCommand;

import discord.bot.mabiHelper.flow.simpleCommand.service.SimpleCommandService;
import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;;
import discord.bot.mabiHelper.spec.simpleCommand.facade.SimpleCommandDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SimpleCommandDiscordLogic implements SimpleCommandDiscordFacade {
    //
    @Autowired
    private SimpleCommandService simpleCommandService;

    @Override
    public SimpleCommand findSimpleCommandByKeyword(String keyword) {
        //
        return simpleCommandService.findByKeyword(keyword);
    }

    @Override
    public List<SimpleCommand> findAllSimpleCommandByCommandType(CommandType commandType) {
        //
        return simpleCommandService.findAllByContentsType(commandType);
    }
}
