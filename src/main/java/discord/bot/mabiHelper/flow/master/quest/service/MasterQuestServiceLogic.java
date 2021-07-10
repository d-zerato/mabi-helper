package discord.bot.mabiHelper.flow.master.quest.service;

import discord.bot.mabiHelper.flow.master.quest.store.MasterQuestStore;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MasterQuestServiceLogic implements MasterQuestService {
    //
    @Autowired
    private MasterQuestStore masterQuestStore;

    @Override
    public String register(MasterQuest masterQuest) {
        //
        return masterQuestStore.create(masterQuest);
    }

    @Override
    public void modify(MasterQuest masterQuest) {
        //
        masterQuest.update();

        masterQuestStore.update(masterQuest);
    }

    @Override
    public void remove(String id) {
        //
        MasterQuest masterQuest = this.findById(id);

        if (masterQuest != null) {
            this.remove(masterQuest);
        }
    }

    @Override
    public void remove(MasterQuest masterQuest) {
        //
        masterQuest.delete();

        masterQuestStore.update(masterQuest);
    }

    @Override
    public MasterQuest findById(String id) {
        //
        return masterQuestStore.retrieve(id);
    }

    @Override
    public List<MasterQuest> findAll() {
        return masterQuestStore.retrieveAll();
    }

    @Override
    public List<MasterQuest> findAllByTalentType(TalentType talentType) {
        //
        return masterQuestStore.retrieveAllByTalentType(talentType);
    }

    @Override
    public List<MasterQuest> findAllByTalentTypeAndQuestNumber(TalentType talentType, int questNumber) {
        //
        return masterQuestStore.retrieveAllByTalentTypeAndQuestNumber(talentType, questNumber);
    }
}
