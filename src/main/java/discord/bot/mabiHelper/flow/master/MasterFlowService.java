package discord.bot.mabiHelper.flow.master;

import discord.bot.mabiHelper.flow.master.quest.service.MasterQuestService;
import discord.bot.mabiHelper.spec.master.facade.MasterResourceFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;
import discord.bot.mabiHelper.spec.share.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MasterFlowService extends MasterDiscordLogic implements MasterResourceFacade {
    //
    @Autowired
    private MasterQuestService questService;

    @Override
    public String registerMasterQuest(MasterQuestCdo masterQuestCdo) {
        //
        MasterQuest masterQuest = new MasterQuest(
                masterQuestCdo.getTalentType(),
                masterQuestCdo.getQuestNumber(),
                masterQuestCdo.getContents(),
                masterQuestCdo.getRecommendGrade()
        );

        return questService.register(masterQuest);
    }

    @Override
    public void modifyMasterQuest(String id, MasterQuestUdo masterQuestUdo) {
        //
        MasterQuest masterQuest = questService.findById(id);

        if (masterQuestUdo.getQuestNumber() > 0
                && masterQuest.getQuestNumber() != masterQuestUdo.getQuestNumber()) {
            //
            masterQuest.setQuestNumber(masterQuestUdo.getQuestNumber());
        }

        if (StringUtil.isNotEmpty(masterQuestUdo.getContents())) {
            //
            masterQuest.setContents(masterQuestUdo.getContents());
        }

        if (masterQuestUdo.getRecommendGrade() != null && masterQuestUdo.getRecommendGrade().equals(masterQuest.getRecommendGrade())) {
            masterQuest.setRecommendGrade(masterQuestUdo.getRecommendGrade());
        }

        questService.modify(masterQuest);
    }

    @Override
    public void removeMasterQuest(String id) {
        //
        MasterQuest masterQuest = questService.findById(id);

        questService.remove(masterQuest);
    }

    @Override
    public MasterQuest findMasterQuest(String id) {
        //
        return questService.findById(id);
    }

    @Override
    public List<MasterQuest> findAllMasterQuest() {
        //
        return questService.findAll();
    }
}
