package discord.bot.mabiHelper.spec.master.facade;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;

import java.util.List;

public interface MasterDiscordFacade {
    //
    List<MasterQuest> findAllByTalent(TalentType talentType);
    List<MasterQuest> findAllByTalentAndQuestNum(TalentType talentType, int questNumber);
    List<MasterQuest> findAllSummariesByRecommend();
}
