package discord.bot.mabiHelper.resource.master;

import discord.bot.mabiHelper.flow.master.TalentFlowService;
import discord.bot.mabiHelper.spec.master.facade.TalentFacade;
import discord.bot.mabiHelper.spec.master.sdo.TalentKeywordCdo;
import discord.bot.mabiHelper.spec.master.sdo.TalentKeywordUdo;
import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/talent")
public class TalentResource implements TalentFacade {
    //
    @Autowired
    private TalentFlowService talentFlowService;

    @Override
    @PostMapping
    public String registerTalentKeyword(@RequestBody TalentKeywordCdo talentKeywordCdo) {
        //
        return talentFlowService.registerTalentKeyword(talentKeywordCdo);
    }

    @Override
    @PutMapping("/{id}")
    public void modifyTalentKeyword(@PathVariable String id, @RequestBody TalentKeywordUdo talentKeywordUdo) {
        //
        talentFlowService.modifyTalentKeyword(id, talentKeywordUdo);
    }

    @Override
    @PutMapping
    public void modifyTypeOfTalentKeyword(@RequestBody TalentKeywordUdo talentKeywordUdo) {
        //
        talentFlowService.modifyTypeOfTalentKeyword(talentKeywordUdo);
    }

    @Override
    @DeleteMapping("/{id}")
    public void removeTalentKeyword(@PathVariable String id) {
        //
        talentFlowService.removeTalentKeyword(id);
    }

    @Override
    @GetMapping("/{id}")
    public TalentKeyword findById(@PathVariable String id) {
        //
        return talentFlowService.findById(id);
    }

    @Override
    @GetMapping
    public TalentKeyword findByKeyword(@RequestParam(name="keyword") String keyword) {
        //
        return talentFlowService.findByKeyword(keyword);
    }

    @Override
    @GetMapping("/type/{type}")
    public List<TalentKeyword> findByType(@PathVariable TalentType type) {
        //
        return talentFlowService.findByType(type);
    }
}
