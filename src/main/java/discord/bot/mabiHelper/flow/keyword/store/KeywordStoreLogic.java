package discord.bot.mabiHelper.flow.keyword.store;

import discord.bot.mabiHelper.flow.keyword.store.repository.KeywordRepository;
import discord.bot.mabiHelper.flow.keyword.store.repository.SearchKeywordJpo;
import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class KeywordStoreLogic implements KeywordStore {
    //
    @Autowired
    private KeywordRepository keywordRepository;

    @Override
    public String create(SearchKeyword searchKeyword) {
        //
        keywordRepository.save(new SearchKeywordJpo(searchKeyword));

        return searchKeyword.getId();
    }

    @Override
    public void creates(List<SearchKeyword> searchKeywordList) {
        //
        keywordRepository.saveAll(searchKeywordList.stream().map(SearchKeywordJpo::new).collect(Collectors.toList()));
    }

    @Override
    public void update(SearchKeyword searchKeyword) {
        //
        keywordRepository.save(new SearchKeywordJpo(searchKeyword));
    }

    @Override
    public void delete(SearchKeyword searchKeyword) {
        //
        keywordRepository.delete(new SearchKeywordJpo(searchKeyword));
    }

    @Override
    public SearchKeyword retrieveById(String id) {
        //
        return keywordRepository.findById(id).map(SearchKeywordJpo::toDomain).orElse(null);
    }

    @Override
    public SearchKeyword retrieveByKeyword(String keyword) {
        //
        return Optional.ofNullable(keywordRepository.findByKeyword(keyword)).map(SearchKeywordJpo::toDomain).orElse(null);
    }

    @Override
    public List<SearchKeyword> retrieveAllByKeywordList(List<String> keywords) {
        //
        return keywordRepository.findAllByKeywordInOrderByCategoryDesc(keywords).stream().map(SearchKeywordJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<SearchKeyword> retrieveAllByCategory(SearchCategory searchCategory) {
        //
        return keywordRepository.findAllByCategoryOrderByCategoryDesc(searchCategory).stream().map(SearchKeywordJpo::toDomain).collect(Collectors.toList());
    }
}
