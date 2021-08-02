package discord.bot.mabiHelper.flow.keyword;

import discord.bot.mabiHelper.flow.keyword.service.KeywordService;
import discord.bot.mabiHelper.flow.master.quest.service.MasterQuestService;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.keyword.SearchTypeKeywordsCdo;
import discord.bot.mabiHelper.spec.keyword.facade.SearchKeywordResourceFacade;
import discord.bot.mabiHelper.spec.keyword.sdo.SearchKeywordCdo;
import discord.bot.mabiHelper.spec.master.facade.MasterResourceFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;
import discord.bot.mabiHelper.spec.share.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class KeywordFlowService extends KeywordDiscordLogic implements SearchKeywordResourceFacade {
    //
    @Autowired
    private KeywordService keywordService;

    @Override
    public String registerSearchKeyword(SearchKeywordCdo searchKeywordCdo) {
        //
        SearchKeyword searchKeyword = this.findSearchKeywordByKeyword(searchKeywordCdo.getKeyword());

        if (searchKeyword != null) {
            log.error("Duplicate Keyword: [" + searchKeyword.getCategory() + "]: " + searchKeyword.getKeyword());
            return null;
        }

        searchKeyword = new SearchKeyword(searchKeywordCdo.getCategory(), searchKeywordCdo.getKeyword());

        return keywordService.register(searchKeyword);
    }

    @Override
    public int registerSearchKeywords(SearchTypeKeywordsCdo searchTypeKeywordsCdo) {
        //
        List<SearchKeyword> searchKeywords = new ArrayList<>();

        List<SearchKeyword> duplicatedObject = keywordService.findAllByKeywordList(searchTypeKeywordsCdo.getKeywords());
        List<String> duplicatedKeyword = duplicatedObject.stream().map(SearchKeyword::getKeyword).collect(Collectors.toList());


        for (String keyword : searchTypeKeywordsCdo.getKeywords()) {
            // 중복 체크
            if (duplicatedKeyword.contains(keyword)) {
                log.error("Duplicate Keyword: [" + searchTypeKeywordsCdo.getCategory() + "]: " + keyword);
                continue;
            }

            SearchKeyword searchKeyword = new SearchKeyword(searchTypeKeywordsCdo.getCategory(), keyword);
            searchKeywords.add(searchKeyword);
        }

        keywordService.registers(searchKeywords);

        return searchKeywords.size();
    }

    @Override
    public String modifyMasterQuest(String id, SearchKeywordCdo searchKeywordCdo) {
        //
        SearchKeyword searchKeyword = this.findSearchKeywordById(id);

        if (searchKeyword == null) {
            return this.registerSearchKeyword(searchKeywordCdo);
        }

        if (!searchKeyword.getCategory().equals(searchKeywordCdo.getCategory())) {
            searchKeyword.setCategory(searchKeywordCdo.getCategory());
        }

        if (!searchKeyword.getKeyword().equals(searchKeywordCdo.getKeyword())) {
            searchKeyword.setKeyword(searchKeywordCdo.getKeyword());
        }

        keywordService.modify(searchKeyword);

        return id;

    }

    @Override
    public void removeMasterQuest(String id) {
        //
        SearchKeyword searchKeyword = this.findSearchKeywordById(id);

        if (searchKeyword != null) {
            keywordService.remove(searchKeyword);
        }
    }

    @Override
    public SearchKeyword findSearchKeywordById(String id) {
        //
        return keywordService.findById(id);
    }
}
