package discord.bot.mabiHelper.flow.master.talent.store.repository;

import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.share.DomainEntity;
import discord.bot.mabiHelper.spec.share.DomainEntityJpo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TALENT_KEYWORD")
public class TalentKeywordJpo extends DomainEntityJpo {
    //
    @Column(unique = true, nullable = false, columnDefinition = "varchar(50) comment '검색 단어'")
    private String keyword;

    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '재능 유형'")
    private TalentType type;


    public TalentKeywordJpo(TalentKeyword talentKeyword) {
        //
        super(talentKeyword);
        BeanUtils.copyProperties(talentKeyword, this);
    }

    public TalentKeyword toDomain() {
        TalentKeyword talentKeyword = new TalentKeyword();
        BeanUtils.copyProperties(this, talentKeyword);
        return talentKeyword;
    }
}
