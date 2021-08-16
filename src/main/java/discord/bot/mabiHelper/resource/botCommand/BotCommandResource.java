package discord.bot.mabiHelper.resource.botCommand;

import discord.bot.mabiHelper.flow.botCommand.BotCommandFlowService;
import discord.bot.mabiHelper.flow.keyword.KeywordFlowService;
import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.facade.BotCommandResourceFacade;
import discord.bot.mabiHelper.spec.botCommand.sdo.BotCommandCdo;
import discord.bot.mabiHelper.spec.botCommand.sdo.BotCommandsCdo;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.keyword.SearchTypeKeywordsCdo;
import discord.bot.mabiHelper.spec.keyword.facade.SearchKeywordResourceFacade;
import discord.bot.mabiHelper.spec.keyword.sdo.SearchKeywordCdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/mabinogi/command")
public class BotCommandResource implements BotCommandResourceFacade {
    //
    @Autowired
    private BotCommandFlowService botCommandFlowService;

    @Override
    @PostMapping
    public String registerCommandWord(@RequestBody BotCommandCdo botCommandCdo) {
        //
        return botCommandFlowService.registerCommandWord(botCommandCdo);
    }

    @Override
    @PostMapping("/all")
    public int registerBotCommandWords(@RequestBody BotCommandsCdo botCommandsCdo) {
        //
        return botCommandFlowService.registerBotCommandWords(botCommandsCdo);
    }

    @Override
    @PutMapping
    public String modifyCommandWord(@RequestBody SearchKeywordCdo searchKeywordCdo) {
        //
        return botCommandFlowService.modifyCommandWord(searchKeywordCdo);
    }

    @Override
    public void removeCommandWord(String commandWord) {
        //
        botCommandFlowService.removeCommandWord(commandWord);
    }

    @Override
    public BotCommand findCommandByWord(String commandWord) {
        //
        return botCommandFlowService.findCommandByWord(commandWord);
    }
}
