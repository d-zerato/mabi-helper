package discord.bot.mabiHelper.spec.master.sdo;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MasterQuestUdo {
    //
    private int questNumber;
    private String contents;
    private RecommendGrade recommendGrade;
}
