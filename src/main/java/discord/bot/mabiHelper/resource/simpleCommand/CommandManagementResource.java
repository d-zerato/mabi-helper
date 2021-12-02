package discord.bot.mabiHelper.resource.simpleCommand;

import discord.bot.mabiHelper.flow.commandManagement.CommandManagementFlowService;
import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.facade.CommandManagementResourceFacade;
import discord.bot.mabiHelper.spec.commandManagement.sdo.SimpleCommandCdo;
import discord.bot.mabiHelper.spec.commandManagement.sdo.SimpleCommandsCdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mabinogi/keyword")
public class CommandManagementResource implements CommandManagementResourceFacade {
    //
    @Autowired
    private CommandManagementFlowService keywordFlowService;

    @Override
    @PostMapping
    public String registerSimpleCommand(@RequestBody SimpleCommandCdo simpleCommandCdo) {
        //
        return keywordFlowService.registerSimpleCommand(simpleCommandCdo);
    }

    @Override
    @PostMapping("/multi")
    public int registerSimpleCommands(@RequestBody SimpleCommandsCdo simpleCommandsCdo) {
        //
        return keywordFlowService.registerSimpleCommands(simpleCommandsCdo);
    }

    @Override
    @PutMapping("/{id}")
    public String modifySimpleCommand(@PathVariable(name = "id") String id,
                                      @RequestBody SimpleCommandCdo simpleCommandCdo) {
        //
        return keywordFlowService.modifySimpleCommand(id, simpleCommandCdo);
    }

    @Override
    @DeleteMapping("/{id}")
    public void removeSimpleCommand(@PathVariable(name = "id") String id) {
        //
        keywordFlowService.removeSimpleCommand(id);
    }

    @Override
    @GetMapping("/{id}")
    public CommandKeyword findSimpleCommandById(@PathVariable(name = "id") String id) {
        //
        return keywordFlowService.findSimpleCommandById(id);
    }
}
