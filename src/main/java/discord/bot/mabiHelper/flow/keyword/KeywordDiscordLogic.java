package discord.bot.mabiHelper.flow.keyword;

import discord.bot.mabiHelper.flow.keyword.service.KeywordService;
import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.keyword.facade.SearchKeywordDiscordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KeywordDiscordLogic implements SearchKeywordDiscordFacade {
    //
    @Autowired
    private KeywordService keywordService;

    @Override
    public SearchKeyword findSearchKeywordByKeyword(String keyword) {
        //
        return keywordService.findByKeyword(keyword);
    }

    @Override
    public List<SearchKeyword> findAllByCategory(SearchCategory category) {
        //
        return keywordService.findAllByContentsType(category);
    }
}
