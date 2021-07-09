package discord.bot.mabiHelper.spec.master;

import lombok.Getter;

@Getter
public enum TalentType {
    //
    WARRIOR("warrior", "근접 전투");

    private String talentType;
    private String talentName;

    TalentType(String talentType, String talentName) {
        //
        this.talentType = talentType;
        this.talentName = talentName;
    }
}
