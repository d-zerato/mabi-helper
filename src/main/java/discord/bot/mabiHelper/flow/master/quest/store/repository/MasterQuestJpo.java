package discord.bot.mabiHelper.flow.master.quest.store.repository;

import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.quest.RecommendGrade;
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
@Table(name = "MASTER_QUEST")
public class MasterQuestJpo extends DomainEntityJpo {
    //
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '재능 유형'")
    private TalentType talentType;

    @Column(unique = false, nullable = true, columnDefinition = "int(1) default 1 comment '퀘스트 번호'")
    private int questNumber;

    @Column(unique = false, nullable = true, columnDefinition = "varchar(2000) comment '퀘스트 내용'")
    private String contents;

    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '추천 등급'")
    private RecommendGrade recommendGrade;

    public MasterQuestJpo(MasterQuest masterQuest) {
        //
        super(masterQuest);
        BeanUtils.copyProperties(masterQuest, this);
    }
    
    public MasterQuest toDomain() {
        //
        MasterQuest masterQuest = new MasterQuest();

        BeanUtils.copyProperties(this, masterQuest);
        masterQuest.setRecommendKorName(this.recommendGrade.getKorName());

        return masterQuest;
    }
}
