package discord.bot.mabiHelper.flow.keyword.service;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;

import java.util.List;

public interface KeywordService {
    //
    String register(SearchKeyword searchKeyword);
    boolean registers(List<SearchKeyword> searchKeywordList);
    void modify(SearchKeyword searchKeyword);
    void remove(SearchKeyword searchKeyword);

    SearchKeyword findById(String id);
    SearchKeyword findByKeyword(String keyword);
    List<SearchKeyword> findAllByKeywordList(List<String> keywords);
    List<SearchKeyword> findAllByContentsType(SearchCategory searchCategory);
}
