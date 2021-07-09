package discord.bot.mabiHelper.spec.master.sdo;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MasterQuestCdo {
    //
    private TalentType talentType;
    private int questNumber;
    private String contents;
    private RecommendGrade recommendGrade;
}
