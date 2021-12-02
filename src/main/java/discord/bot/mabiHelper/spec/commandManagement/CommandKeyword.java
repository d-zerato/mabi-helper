package discord.bot.mabiHelper.spec.commandManagement;

import discord.bot.mabiHelper.spec.share.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandKeyword extends DomainEntity {
    //
    private String keyword;
    private CommandType commandType;

    public CommandKeyword() {
        super();
        this.commandType = CommandType.NONE;
        this.keyword = "";
    }

    public CommandKeyword(CommandType commandType,
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
