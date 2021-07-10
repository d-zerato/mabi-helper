package discord.bot.mabiHelper.spec.master.facade;

import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;

import java.util.List;

public interface MasterResourceFacade {
    //
    String registerMasterQuest(MasterQuestCdo masterQuestCdo);
    void modifyMasterQuest(String id, MasterQuestUdo masterQuestUdo);
    void removeMasterQuest(String id);

    MasterQuest findMasterQuest(String id);
    List<MasterQuest> findAllMasterQuest();
}
