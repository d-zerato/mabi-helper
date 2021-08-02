package discord.bot.mabiHelper.flow.keyword.store.repository;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepository extends JpaRepository<SearchKeywordJpo, String> {
    //
    SearchKeywordJpo findByKeyword(String keyword);
    List<SearchKeywordJpo> findAllByKeywordInOrderByCategoryDesc(List<String> keyword);
    List<SearchKeywordJpo> findAllByCategoryOrderByCategoryDesc(SearchCategory category);
}
