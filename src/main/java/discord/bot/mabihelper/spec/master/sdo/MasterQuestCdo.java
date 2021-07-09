package discord.bot.mabihelper.spec.master.sdo;

import discord.bot.mabihelper.spec.master.TalentType;
import discord.bot.mabihelper.spec.master.quest.RecommendGrade;
import discord.bot.mabihelper.spec.share.DomainEntity;
import lombok.AllArgsConstructor;
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
