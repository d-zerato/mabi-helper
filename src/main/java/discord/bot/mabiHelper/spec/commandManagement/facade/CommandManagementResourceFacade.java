package discord.bot.mabiHelper.spec.commandManagement.facade;

import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.sdo.SimpleCommandCdo;
import discord.bot.mabiHelper.spec.commandManagement.sdo.SimpleCommandsCdo;

public interface CommandManagementResourceFacade {
    //
    String registerSimpleCommand(SimpleCommandCdo simpleCommandCdo);

    int registerSimpleCommands(SimpleCommandsCdo simpleCommandsCdo);

    String modifySimpleCommand(String id, SimpleCommandCdo simpleCommandCdo);

    void removeSimpleCommand(String id);

    CommandKeyword findSimpleCommandById(String id);
}
