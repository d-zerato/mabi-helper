package discord.bot.mabiHelper.spec.simpleCommand.facade;

import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;
import discord.bot.mabiHelper.spec.simpleCommand.sdo.SimpleCommandCdo;
import discord.bot.mabiHelper.spec.simpleCommand.sdo.SimpleCommandsCdo;;

public interface SimpleCommandResourceFacade {
    //
    String registerSimpleCommand(SimpleCommandCdo simpleCommandCdo);
    int registerSimpleCommands(SimpleCommandsCdo simpleCommandsCdo);
    String modifySimpleCommand(String id, SimpleCommandCdo simpleCommandCdo);
    void removeSimpleCommand(String id);

    SimpleCommand findSimpleCommandById(String id);
}
