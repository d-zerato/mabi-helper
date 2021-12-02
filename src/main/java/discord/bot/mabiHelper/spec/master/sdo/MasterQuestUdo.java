package discord.bot.mabiHelper.spec.master.sdo;

import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MasterQuestUdo {
    //
    private int questNumber;
    private String contents;
    private RecommendGrade recommendGrade;
}
