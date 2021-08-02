package discord.bot.mabiHelper.resource.keyword;

import discord.bot.mabiHelper.flow.keyword.KeywordDiscordLogic;
import discord.bot.mabiHelper.flow.master.MasterFlowService;
import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.keyword.facade.SearchKeywordDiscordFacade;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.facade.MasterDiscordFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/mabinogi/discord/keyword")
public class SearchKeywordDiscordResource implements SearchKeywordDiscordFacade {
    //
    @Autowired
    private KeywordDiscordLogic keywordDiscordLogic;

    @Override
    @GetMapping("/{keyword}")
    public SearchKeyword findSearchKeywordByKeyword(@PathVariable(name="keyword") String keyword) {
        //
        return keywordDiscordLogic.findSearchKeywordByKeyword(keyword);
    }

    @Override
    @GetMapping("/all/{category}")
    public List<SearchKeyword> findAllByCategory(@PathVariable(name="category") SearchCategory category) {
        //
        return keywordDiscordLogic.findAllByCategory(category);
    }
}
