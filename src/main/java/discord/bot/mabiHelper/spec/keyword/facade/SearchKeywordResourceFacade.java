package discord.bot.mabiHelper.spec.keyword.facade;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.keyword.SearchTypeKeywordsCdo;
import discord.bot.mabiHelper.spec.keyword.sdo.SearchKeywordCdo;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;

import java.util.List;

public interface SearchKeywordResourceFacade {
    //
    String registerSearchKeyword(SearchKeywordCdo searchKeywordCdo);
    int registerSearchKeywords(SearchTypeKeywordsCdo searchTypeKeywordsCdo);
    String modifyMasterQuest(String id, SearchKeywordCdo searchKeywordCdo);
    void removeMasterQuest(String id);

    SearchKeyword findSearchKeywordById(String id);
}
