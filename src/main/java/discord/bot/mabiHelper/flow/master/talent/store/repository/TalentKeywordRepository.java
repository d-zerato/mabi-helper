package discord.bot.mabiHelper.flow.master.talent.store.repository;

import discord.bot.mabiHelper.spec.master.talent.TalentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentKeywordRepository extends JpaRepository<TalentKeywordJpo, String> {
    //
    TalentKeywordJpo findByKeyword(String keyword);
    List<TalentKeywordJpo> findAllByTypeOrderByCreatedAtDesc(TalentType type);
}
