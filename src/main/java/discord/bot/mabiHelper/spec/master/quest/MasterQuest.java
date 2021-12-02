package discord.bot.mabiHelper.spec.master.quest;

import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.share.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MasterQuest extends DomainEntity {
    //
    private TalentType talentType;
    private int questNumber;
    private String contents;
    private RecommendGrade recommendGrade;
    private String recommendKorName;

    public MasterQuest() {
        //
        super();
        this.talentType = null;
        this.questNumber = 1;
        this.contents = "";
        this.recommendGrade = RecommendGrade.NORMAL;
        this.recommendKorName = RecommendGrade.NORMAL.getKorName();
    }

    public MasterQuest(TalentType talentType,
                       int questNumber,
                       String contents) {
        //
        this();
        this.talentType = talentType;
        this.questNumber = questNumber;
        this.contents = contents;
    }

    public MasterQuest(TalentType talentType,
                       int questNumber,
                       String contents,
                       RecommendGrade recommendGrade) {
        //
        this();
        this.talentType = talentType;
        this.questNumber = questNumber;
        this.contents = contents;
        this.recommendGrade = recommendGrade;
        this.recommendKorName = recommendGrade.getKorName();
    }

    public void setRecommendGrade(RecommendGrade recommendGrade) {
        this.recommendGrade = recommendGrade;
        this.recommendKorName = recommendGrade.getKorName();
    }
}
