package discord.bot.mabiHelper.flow.master.quest.store;

import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;

import java.util.List;

public interface MasterQuestStore {
    //
    void create(MasterQuest masterQuest);
    void update(MasterQuest masterQuest);
    void delete(MasterQuest masterQuest);

    List<MasterQuest> retrieveAll();
    MasterQuest retrieve(String id);
    List<MasterQuest> retrieveAllByTalentType(TalentType talentType);
    List<MasterQuest> retrieveAllByTalentTypeAndQuestNumber(TalentType talentType, int questNumber);
    List<MasterQuest> retrieveAllGroupByTalentTypeAndQuestNumber();
}
