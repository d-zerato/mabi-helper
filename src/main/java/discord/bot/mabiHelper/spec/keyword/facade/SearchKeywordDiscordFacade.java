package discord.bot.mabiHelper.spec.keyword.facade;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;

import java.util.List;

public interface SearchKeywordDiscordFacade {
    //
    SearchKeyword findSearchKeywordByKeyword(String keyword);
    List<SearchKeyword> findAllByCategory(SearchCategory category);
}
