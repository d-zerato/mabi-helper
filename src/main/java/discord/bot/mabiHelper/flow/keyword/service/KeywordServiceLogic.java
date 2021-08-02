package discord.bot.mabiHelper.flow.keyword.service;

import discord.bot.mabiHelper.flow.keyword.store.KeywordStore;
import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KeywordServiceLogic implements KeywordService {
    //
    @Autowired
    private KeywordStore keywordStore;

    @Override
    public String register(SearchKeyword searchKeyword) {
        //
        return keywordStore.create(searchKeyword);
    }

    @Override
    public boolean registers(List<SearchKeyword> searchKeywordList) {
        if(searchKeywordList == null || searchKeywordList.size() <= 0) {
            return false;
        }

        keywordStore.creates(searchKeywordList);
        return true;
    }

    @Override
    public void modify(SearchKeyword searchKeyword) {
        //
        searchKeyword.update();
        keywordStore.update(searchKeyword);
    }

    @Override
    public void remove(SearchKeyword searchKeyword) {
        //
//        searchKeyword.delete();
        keywordStore.delete(searchKeyword);
    }

    @Override
    public SearchKeyword findById(String id) {
        //
        return keywordStore.retrieveById(id);
    }

    @Override
    public SearchKeyword findByKeyword(String keyword) {
        //
        return keywordStore.retrieveByKeyword(keyword);
    }

    @Override
    public List<SearchKeyword> findAllByKeywordList(List<String> keywords) {
        //
        return keywordStore.retrieveAllByKeywordList(keywords);
    }

    @Override
    public List<SearchKeyword> findAllByContentsType(SearchCategory searchCategory) {
        //
        return keywordStore.retrieveAllByCategory(searchCategory);
    }
}
