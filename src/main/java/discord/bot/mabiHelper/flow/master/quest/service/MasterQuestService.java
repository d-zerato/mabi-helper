package discord.bot.mabiHelper.flow.master.quest.service;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;

import java.util.List;

public interface MasterQuestService {
    //
    String register(MasterQuestCdo masterQuestCdo);
    void modify(MasterQuest masterQuest);
    void remove(String id);
    void remove(MasterQuest masterQuest);

    MasterQuest findById(String id);
    List<MasterQuest> findAll();
    List<MasterQuest> findAllByTalentType(TalentType talentType);
}
