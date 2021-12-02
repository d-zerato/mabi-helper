package discord.bot.mabiHelper.spec.master.talent;

import discord.bot.mabiHelper.spec.share.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalentKeyword extends DomainEntity {
    //
    private String keyword;
    private TalentType type;

    public TalentKeyword() {
        //
        super();
    }

    public TalentKeyword(String keyword, TalentType type) {
        //
        this();
        this.keyword = keyword;
        this.type = type;
    }
}
