package discord.bot.mabiHelper.spec.master.quest;

import lombok.Getter;

@Getter
public enum RecommendGrade {
    //
    BEST("best", "추천"),
    NORMAL("normal", "보통"),
    WORST("worst", "비추천");

    private String grade;
    private String korName;

    RecommendGrade(String grade, String korName) {
        //
        this.grade = grade;
        this.korName = korName;
    }
}
