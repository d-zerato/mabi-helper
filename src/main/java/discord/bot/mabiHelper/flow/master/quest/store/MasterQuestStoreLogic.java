package discord.bot.mabiHelper.flow.master.quest.store;

import discord.bot.mabiHelper.flow.master.quest.store.repository.MasterQuestJpo;
import discord.bot.mabiHelper.flow.master.quest.store.repository.MasterQuestRepository;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MasterQuestStoreLogic implements MasterQuestStore {
    //
    @Autowired
    private MasterQuestRepository masterQuestRepository;

    @Override
    public String create(MasterQuest masterQuest) {
        //
        masterQuestRepository.save(new MasterQuestJpo(masterQuest));

        return masterQuest.getId();
    }

    @Override
    public void update(MasterQuest masterQuest) {
        //
        masterQuestRepository.save(new MasterQuestJpo(masterQuest));
    }

    @Override
    public void delete(MasterQuest masterQuest) {
        //
        masterQuestRepository.delete(new MasterQuestJpo(masterQuest));
    }

    @Override
    public List<MasterQuest> retrieveAll() {
        //
        return masterQuestRepository.findAll().stream().map(MasterQuestJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public MasterQuest retrieve(String id) {
        //
        return masterQuestRepository.findById(id).map(MasterQuestJpo::toDomain).orElse(null);
    }

    @Override
    public List<MasterQuest> retrieveAllByTalentType(TalentType talentType) {
        //
        return masterQuestRepository
                .findAllByTalentTypeAndDeletedFalseOrderByQuestNumberAsc(talentType)
                .stream().map(MasterQuestJpo::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<MasterQuest> retrieveAllByTalentTypeAndQuestNumber(TalentType talentType, int questNumber) {
        return masterQuestRepository
                .findAllByTalentTypeAndQuestNumberAndDeletedFalseOrderByQuestNumberAsc(talentType, questNumber)
                .stream()
                .map(MasterQuestJpo::toDomain)
                .collect(Collectors.toList());
    }
}
