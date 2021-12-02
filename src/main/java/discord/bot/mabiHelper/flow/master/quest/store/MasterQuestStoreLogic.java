package discord.bot.mabiHelper.flow.master.quest.store;

import discord.bot.mabiHelper.flow.master.quest.store.repository.MasterQuestJpo;
import discord.bot.mabiHelper.flow.master.quest.store.repository.MasterQuestRepository;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MasterQuestStoreLogic implements MasterQuestStore {
    //
    @Autowired
    private MasterQuestRepository masterQuestRepository;

    @Override
    public void create(MasterQuest masterQuest) {
        //
        masterQuestRepository.save(new MasterQuestJpo(masterQuest));
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
        //
        return masterQuestRepository
                .findAllByTalentTypeAndQuestNumberAndDeletedFalseOrderByQuestNumberAsc(talentType, questNumber)
                .stream()
                .map(MasterQuestJpo::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<MasterQuest> retrieveAllGroupByTalentTypeAndQuestNumber() {
        //
//        String query = ""+
//                "select * " +
//                "from ( " +
//                "   select mq.talent_type, " +
//                "       mq.quest_number, " +
//                "       mq.recommend_grade " +
//                "   from master_quest mq " +
//                "   order by " +
//                "       mq.talent_type, " +
//                "       mq.quest_number, " +
//                "       case " +
//                "           when mq.recommend_grade = :first then 1 " +
//                "           when mq.recommend_grade = :second then 2 " +
//                "           when mq.recommend_grade = :thirds then 3 " +
//                "       end) mq " +
//                "group by mq.talent_type, mq.quest_number ";
//
//        List<MasterQuestJpo> quesJpotList = EntityManager
//
//        TypedQuery<MasterQuestJpo>

        return masterQuestRepository
                .findQuestSummaries(RecommendGrade.WORST,
                        RecommendGrade.NORMAL,
                        RecommendGrade.BEST)
                .stream()
                .map(MasterQuestJpo::toDomain)
                .collect(Collectors.toList());
    }
}
