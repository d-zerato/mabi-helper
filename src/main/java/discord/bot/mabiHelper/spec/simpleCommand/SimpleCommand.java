package discord.bot.mabiHelper.spec.simpleCommand;

import discord.bot.mabiHelper.spec.share.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCommand extends DomainEntity {
    //
    private String keyword;
    private CommandType commandType;

    public SimpleCommand() {
        super();
        this.commandType = CommandType.NONE;
        this.keyword = "";
    }

    public SimpleCommand(CommandType commandType,
                         String keyword) {
        //
        super();
        this.keyword = keyword;
        this.commandType = commandType;
    }

    public void setCommandType(CommandType commandType) {
        //
        this.commandType = this.commandType;
        this.keyword = keyword;
    }
}
