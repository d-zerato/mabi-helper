package discord.bot.mabiHelper.resource.botCommand;

import discord.bot.mabiHelper.flow.botCommand.BotCommandDiscordLogic;
import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import discord.bot.mabiHelper.spec.botCommand.facade.BotCommandDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/mabinogi/discord/command")
public class BotCommandDiscordResource implements BotCommandDiscordFacade {
    //
    @Autowired
    private BotCommandDiscordLogic botCommandDiscordLogic;

    @Override
    @GetMapping("/{command}")
    public BotCommand findDiscordCommandByword(@PathVariable(name="command") String commandWord) {
        //
        return botCommandDiscordLogic.findDiscordCommandByword(commandWord);
    }

    @Override
    @PostMapping
    public List<BotCommand> findAllByCategory(@RequestParam(name="category") CommandCategory category) {
        //
        return botCommandDiscordLogic.findAllByCategory(category);
    }
}
