package discord.bot.mabiHelper.resource.master;

import discord.bot.mabiHelper.flow.master.MasterFlowService;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.master.facade.MasterDiscordFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/discord/master")
public class MasterDiscordResource implements MasterDiscordFacade {
    //
    @Autowired
    private MasterFlowService masterFlow;

    @Override
    @GetMapping("/{type}")
    public List<MasterQuest> findAllByTalent(@PathVariable(name = "type") TalentType type) {
        //
        return masterFlow.findAllByTalent(type);
    }

    @Override
    @GetMapping("/{type}/{number}")
    public List<MasterQuest> findAllByTalentAndQuestNum(@PathVariable(name = "type") TalentType type,
                                                        @PathVariable(name = "number")int questNumber) {
        //
        return masterFlow.findAllByTalent(type);
    }

    @Override
    @GetMapping("/quest/summary")
    public List<MasterQuest> findAllSummariesByRecommend() {
        //
        return masterFlow.findAllSummariesByRecommend();
    }
}
