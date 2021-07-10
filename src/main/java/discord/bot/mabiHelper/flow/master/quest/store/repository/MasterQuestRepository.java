package discord.bot.mabiHelper.flow.master.quest.store.repository;

import discord.bot.mabiHelper.spec.master.TalentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterQuestRepository extends JpaRepository<MasterQuestJpo, String> {
    //
    List<MasterQuestJpo> findAllByTalentTypeAndDeletedFalseOrderByQuestNumberAsc(TalentType talentType);
    List<MasterQuestJpo> findAllByTalentTypeAndQuestNumberAndDeletedFalseOrderByQuestNumberAsc(TalentType talentType, int questNumber);
}
