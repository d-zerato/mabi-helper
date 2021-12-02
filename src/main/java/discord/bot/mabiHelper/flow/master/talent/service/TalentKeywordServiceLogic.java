package discord.bot.mabiHelper.flow.master.talent.service;

import discord.bot.mabiHelper.flow.master.talent.store.TalentKeywordStore;
import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TalentKeywordServiceLogic implements TalentKeywordService {
    //
    @Autowired
    private TalentKeywordStore talentKeywordStore;

    @Override
    public String register(TalentKeyword talentKeyword) {
        //
        talentKeywordStore.create(talentKeyword);

        return talentKeyword.getId();
    }

    @Override
    public void modify(TalentKeyword talentKeyword) {
        //
        talentKeywordStore.update(talentKeyword);
    }

    @Override
    public void remove(String id) {
        //
        TalentKeyword talentKeyword = talentKeywordStore.retrieveById(id);

        this.remove(talentKeyword);
    }

    @Override
    public void remove(TalentKeyword talentKeyword) {
        //
        talentKeywordStore.delete(talentKeyword);
    }

    @Override
    public TalentKeyword findById(String id) {
        //
        return talentKeywordStore.retrieveById(id);
    }

    @Override
    public TalentKeyword findByKeyword(String keyword) {
        //
        return talentKeywordStore.retrieveByKeyword(keyword);
    }

    @Override
    public List<TalentKeyword> findAllByType(TalentType talentType) {
        //
        return talentKeywordStore.retrieveAllByType(talentType);
    }
}
