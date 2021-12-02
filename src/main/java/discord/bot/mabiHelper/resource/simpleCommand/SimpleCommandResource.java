package discord.bot.mabiHelper.resource.simpleCommand;

import discord.bot.mabiHelper.flow.simpleCommand.SimpleCommandFlowService;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;
import discord.bot.mabiHelper.spec.simpleCommand.facade.SimpleCommandResourceFacade;
import discord.bot.mabiHelper.spec.simpleCommand.sdo.SimpleCommandCdo;
import discord.bot.mabiHelper.spec.simpleCommand.sdo.SimpleCommandsCdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mabinogi/keyword")
public class SimpleCommandResource implements SimpleCommandResourceFacade {
    //
    @Autowired
    private SimpleCommandFlowService keywordFlowService;

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
    public SimpleCommand findSimpleCommandById(@PathVariable(name = "id") String id) {
        //
        return keywordFlowService.findSimpleCommandById(id);
    }
}
