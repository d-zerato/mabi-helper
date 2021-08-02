package discord.bot.mabiHelper.resource.master;

import discord.bot.mabiHelper.flow.master.MasterFlowService;
import discord.bot.mabiHelper.spec.master.TalentType;
import discord.bot.mabiHelper.spec.master.facade.MasterDiscordFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/mabinogi/discord/master")
public class MasterDiscordResource implements MasterDiscordFacade {
    //
    @Autowired
    private MasterFlowService masterFlow;

    @Override
    @GetMapping("/quest/{talent}")
    public List<MasterQuest> findAllByTalent(@PathVariable(name = "talent") TalentType talentType) {
        //
        return masterFlow.findAllByTalent(talentType);
    }

    @Override
    @GetMapping("/quest/{talent}/{number}")
    public List<MasterQuest> findAllByTalentAndQuestNum(@PathVariable(name = "talent") TalentType talentType,
                                                        @PathVariable(name = "number")int questNumber) {
        //
        return masterFlow.findAllByTalent(talentType);
    }

    @Override
    @GetMapping("/quest/summary")
    public List<MasterQuest> findAllSummariesByRecommend() {
        //
        return masterFlow.findAllSummariesByRecommend();
    }
}
