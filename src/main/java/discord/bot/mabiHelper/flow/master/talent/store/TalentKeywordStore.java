package discord.bot.mabiHelper.flow.master.talent.store;

import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;

import java.util.List;

public interface TalentKeywordStore {
    //
    void create(TalentKeyword talentKeyword);
    void update(TalentKeyword talentKeyword);
    void delete(TalentKeyword talentKeyword);

    TalentKeyword retrieveById(String id);
    TalentKeyword retrieveByKeyword(String keyword);
    List<TalentKeyword> retrieveAllByType(TalentType talentType);
}
