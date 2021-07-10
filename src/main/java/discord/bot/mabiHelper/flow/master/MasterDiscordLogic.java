package discord.bot.mabiHelper.flow.master;

import discord.bot.mabiHelper.flow.master.quest.service.MasterQuestService;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.facade.MasterDiscordFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MasterDiscordLogic implements MasterDiscordFacade {
    //
    @Autowired
    private MasterQuestService questService;

    @Override
    public List<MasterQuest> findAllByTalent(TalentType talentType) {
        //
        return questService.findAllByTalentType(talentType);
    }

    @Override
    public List<MasterQuest> findAllByTalentAndQuestNum(TalentType talentType, int questNumber) {
        //
        return questService.findAllByTalentTypeAndQuestNumber(talentType, questNumber);
    }
}
