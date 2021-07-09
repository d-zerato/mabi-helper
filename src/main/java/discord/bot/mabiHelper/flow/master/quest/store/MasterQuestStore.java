package discord.bot.mabiHelper.flow.master.quest.store;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;

import java.util.List;

public interface MasterQuestStore {
    //
    String create(MasterQuest masterQuest);
    void update(MasterQuest masterQuest);
    void delete(MasterQuest masterQuest);

    List<MasterQuest> retrieveAll();
    MasterQuest retrieve(String id);
    List<MasterQuest> retrieveAllByTalentType(TalentType talentType);
}
