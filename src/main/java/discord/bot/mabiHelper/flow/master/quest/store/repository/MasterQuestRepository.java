package discord.bot.mabiHelper.flow.master.quest.store.repository;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;

public interface MasterQuestRepository extends JpaRepository<MasterQuestJpo, String> {
    //
    List<MasterQuestJpo> findAllByTalentTypeAndDeletedFalseOrderByQuestNumberAsc(TalentType talentType);
    List<MasterQuestJpo> findAllByTalentTypeAndQuestNumberAndDeletedFalseOrderByQuestNumberAsc(TalentType talentType, int questNumber);
    @Query(value="select m.* " +
            "from ( " +
            "   select mq.* " +
            "   from mabinogi.master_quest mq " +
            "   order by " +
            "       mq.talent_type, " +
            "       mq.quest_number, " +
            "       case  " +
            "           when mq.recommend_grade = 'WORST' then 1 " +
            "           when mq.recommend_grade = 'NORMAL' then 2 " +
            "           when mq.recommend_grade = 'BEST' then 3 " +
            "       end) m " +
            "group by m.talent_type_ko_name, m.talent_type, m.quest_number ", nativeQuery = true)
    List<MasterQuestJpo> findQuestSummaries(@Param("first") RecommendGrade first,
                                            @Param("second")RecommendGrade second,
                                            @Param("thirds")RecommendGrade thirds);
}
