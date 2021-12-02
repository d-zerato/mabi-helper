package discord.bot.mabiHelper.spec.master.sdo;

import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TalentKeywordCdo {
    //
    private TalentType type;
    private String keyword;
}
