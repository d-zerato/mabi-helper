package discord.bot.mabiHelper.resource.master;

import discord.bot.mabiHelper.flow.master.MasterFlowService;
import discord.bot.mabiHelper.spec.master.facade.MasterResourceFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/master")
public class MasterResource implements MasterResourceFacade {
    //
    @Autowired
    private MasterFlowService masterFlow;

    @Override
    @PostMapping
    public String registerMasterQuest(@RequestBody MasterQuestCdo masterQuestCdo) {
        //
        return masterFlow.registerMasterQuest(masterQuestCdo);
    }

    @Override
    @PutMapping("/{id}")
    public void modifyMasterQuest(@PathVariable String id,
                                  @RequestBody MasterQuestUdo masterQuestUdo) {

        //
        masterFlow.modifyMasterQuest(id, masterQuestUdo);
    }

    @Override
    @DeleteMapping("/{id}")
    public void removeMasterQuest(@PathVariable String id) {
        //
        masterFlow.removeMasterQuest(id);
    }

    @Override
    @GetMapping("/{id}")
    public MasterQuest findMasterQuest(@PathVariable String id) {
        //
        return masterFlow.findMasterQuest(id);
    }

    @Override
    @GetMapping("/all")
    public List<MasterQuest> findAllMasterQuest() {
        //
        return masterFlow.findAllMasterQuest();
    }
}
