package discord.bot.mabiHelper.flow.botCommand;

import discord.bot.mabiHelper.flow.botCommand.service.BotCommandService;
import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import discord.bot.mabiHelper.spec.botCommand.facade.BotCommandDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BotCommandDiscordLogic implements BotCommandDiscordFacade {
    //
    @Autowired
    private BotCommandService botCommandService;

    @Override
    public BotCommand findDiscordCommandByword(String commandWord) {
        //
        return botCommandService.findByWord(commandWord);
    }

    @Override
    public List<BotCommand> findAllByCategory(CommandCategory category) {
        //
        return botCommandService.findAllByCommandCategory(category);
    }
}
