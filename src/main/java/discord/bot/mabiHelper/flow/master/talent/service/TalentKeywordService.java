package discord.bot.mabiHelper.flow.master.talent.service;

import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;

import java.util.List;

public interface TalentKeywordService {
    //
    String register(TalentKeyword talentKeyword);
    void modify(TalentKeyword talentKeyword);
    void remove(String id);
    void remove(TalentKeyword talentKeyword);

    TalentKeyword findById(String id);
    TalentKeyword findByKeyword(String keyword);
    List<TalentKeyword> findAllByType(TalentType talentType);
}
