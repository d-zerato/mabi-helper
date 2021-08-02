package discord.bot.mabiHelper.resource.keyword;

import discord.bot.mabiHelper.flow.keyword.KeywordFlowService;
import discord.bot.mabiHelper.flow.master.MasterFlowService;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.keyword.SearchTypeKeywordsCdo;
import discord.bot.mabiHelper.spec.keyword.facade.SearchKeywordResourceFacade;
import discord.bot.mabiHelper.spec.keyword.sdo.SearchKeywordCdo;
import discord.bot.mabiHelper.spec.master.facade.MasterResourceFacade;
import discord.bot.mabiHelper.spec.master.quest.MasterQuest;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestCdo;
import discord.bot.mabiHelper.spec.master.sdo.MasterQuestUdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/mabinogi/keyword")
public class SearchKeywordResource implements SearchKeywordResourceFacade {
    //
    @Autowired
    private KeywordFlowService keywordFlowService;

    @Override
    @PostMapping
    public String registerSearchKeyword(@RequestBody SearchKeywordCdo searchKeywordCdo) {
        //
        return keywordFlowService.registerSearchKeyword(searchKeywordCdo);
    }

    @Override
    @PostMapping("/all")
    public int registerSearchKeywords(@RequestBody SearchTypeKeywordsCdo searchTypeKeywordsCdo) {
        //
        return keywordFlowService.registerSearchKeywords(searchTypeKeywordsCdo);
    }

    @Override
    @PutMapping("/{id}")
    public String modifyMasterQuest(@PathVariable(name = "id") String id,
                                    @RequestBody SearchKeywordCdo searchKeywordCdo) {
        //
        return keywordFlowService.modifyMasterQuest(id, searchKeywordCdo);
    }

    @Override
    @DeleteMapping("/{id}")
    public void removeMasterQuest(@PathVariable(name = "id") String id) {
        //
        keywordFlowService.removeMasterQuest(id);
    }

    @Override
    @GetMapping("/{id}")
    public SearchKeyword findSearchKeywordById(@PathVariable(name = "id") String id) {
        //
        return keywordFlowService.findSearchKeywordById(id);
    }
}
