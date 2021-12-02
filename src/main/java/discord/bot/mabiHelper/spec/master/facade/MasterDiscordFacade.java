package discord.bot.mabiHelper.spec.master.facade;

import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;

import java.util.List;

public interface MasterDiscordFacade {
    //
    List<MasterQuest> findAllByTalent(TalentType talentType);
    List<MasterQuest> findAllByTalentAndQuestNum(TalentType talentType, int questNumber);
    List<MasterQuest> findAllSummariesByRecommend();
}
