package discord.bot.mabiHelper.spec.master.facade;

import discord.bot.mabiHelper.spec.master.sdo.TalentKeywordCdo;
import discord.bot.mabiHelper.spec.master.sdo.TalentKeywordUdo;
import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;

import java.util.List;

public interface TalentFacade {
    //
    String registerTalentKeyword(TalentKeywordCdo talentKeywordCdo);
    void modifyTalentKeyword(String id, TalentKeywordUdo talentKeywordUdo);
    void modifyTypeOfTalentKeyword(TalentKeywordUdo talentKeywordUdo);
    void removeTalentKeyword(String id);

    TalentKeyword findById(String id);
    TalentKeyword findByKeyword(String keyword);
    List<TalentKeyword> findByType(TalentType type);
}
