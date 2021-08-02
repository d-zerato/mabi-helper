package discord.bot.mabiHelper.flow.keyword.store;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;

import java.util.List;

public interface KeywordStore {
    //
    String create(SearchKeyword searchKeyword);
    void creates(List<SearchKeyword> searchKeywordList);
    void update(SearchKeyword searchKeyword);
    void delete(SearchKeyword searchKeyword);

    SearchKeyword retrieveById(String id);
    SearchKeyword retrieveByKeyword(String keyword);
    List<SearchKeyword> retrieveAllByKeywordList(List<String> keywords);
    List<SearchKeyword> retrieveAllByCategory(SearchCategory searchCategory);
}
