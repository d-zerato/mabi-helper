package discord.bot.mabiHelper.flow.botCommand;

import discord.bot.mabiHelper.flow.botCommand.service.BotCommandService;
import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.facade.BotCommandResourceFacade;
import discord.bot.mabiHelper.spec.botCommand.sdo.BotCommandCdo;
import discord.bot.mabiHelper.spec.botCommand.sdo.BotCommandsCdo;
import discord.bot.mabiHelper.spec.keyword.sdo.SearchKeywordCdo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class BotCommandFlowService extends BotCommandDiscordLogic implements BotCommandResourceFacade {
    //
    @Autowired
    private BotCommandService botCommandService;

    @Override
    public String registerCommandWord(BotCommandCdo botCommandCdo) {
        return null;
    }

    @Override
    public int registerBotCommandWords(BotCommandsCdo botCommandsCdo) {
        return 0;
    }

    @Override
    public String modifyCommandWord(SearchKeywordCdo searchKeywordCdo) {
        return null;
    }

    @Override
    public void removeCommandWord(String commandWord) {

    }

    @Override
    public BotCommand findCommandByWord(String commandWord) {
        return null;
    }
}
